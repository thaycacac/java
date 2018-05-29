
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Scanner;

/**
 *
 * @author THAYCACAC
 */
public class Manager {

    private static final Scanner in = new Scanner(System.in);

    //check user input file name not empty and must be file .txt
    public static String checkInputFileName() {
        System.out.print("Enter path file: ");
        while (true) {
            String result = in.nextLine();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else if (!result.endsWith(".txt")) {
                System.err.println("Not file .txt");
            } else {
                return result;
            }
            System.out.print("Enter again: ");
        }
    }

    //one space by special characters
    public static String formatOneSpaceSpecial(String line, String character) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strings = line.split("\\s*\\" + character + "\\s*");
        if (strings.length == 1) {
            return line;
        } else {
            for (int i = 0; i < strings.length; i++) {
                stringBuffer.append(strings[i]);
                //check last of string split
                if (i == strings.length - 1) {
                    break;
                }
                stringBuffer.append(" " + character);
                stringBuffer.append(" ");
            }
            return stringBuffer.toString().trim();
        }
    }

    //only one space between words and all character lowercase
    public static String formatOneSpace(String line) {
        line = line.toLowerCase();
        line = line.replaceAll("\\s+", " ");
        line = formatOneSpaceSpecial(line, ".");
        line = formatOneSpaceSpecial(line, ",");
        line = formatOneSpaceSpecial(line, ":");
        line = formatOneSpaceSpecial(line, "\"");
        return line;
    }

    //only one space after comma (,), dot (.) and colon (:). 
    public static String formatSpecialCharacters(String line) {
        StringBuffer stringBuffer = new StringBuffer(line);
        //check from first to last before .,:; then delete
        for (int i = 0; i < stringBuffer.length() - 1; i++) {
            if (stringBuffer.charAt(i) == ' '
                    && stringBuffer.charAt(i + 1) == '.'
                    || stringBuffer.charAt(i + 1) == ','
                    || stringBuffer.charAt(i + 1) == ':') {
                stringBuffer.deleteCharAt(i);
                i--;
            }
        }
        return stringBuffer.toString().trim();
    }

    //first character of word after dot is in Uppercase and other words are in lower case.
    public static String firstAfterDotUpperCase(String line) {
        StringBuffer stringBuffer = new StringBuffer(line);
        int lengthLine = stringBuffer.length();
        //check from first to last after . then UpperCase
        for (int i = 0; i < lengthLine - 2; i++) {
            if (stringBuffer.charAt(i) == '.') {
                stringBuffer.setCharAt(i + 2, Character.toUpperCase(stringBuffer.charAt(i + 2)));
            }
        }
        return stringBuffer.toString().trim();
    }

    //there are no spaces before and after sentence or word phrases in quotes (“”).
    static int countQuetes = 0;

    public static String noSpaceQuotes(String line) {
        StringBuffer stringBuffer = new StringBuffer(line);
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (stringBuffer.charAt(i) == '"' && countQuetes % 2 == 0) {
                stringBuffer.deleteCharAt(i + 1);
                countQuetes++;
            } else if (stringBuffer.charAt(i) == '"' && countQuetes % 2 == 1
                    && i != 0) {
                stringBuffer.deleteCharAt(i - 1);
                countQuetes++;
            }
        }
        return stringBuffer.toString().trim();
    }

    //first character of word in first line is in Uppercase
    public static String firstUpercase(String line) {
        line = line.substring(3);
        System.out.println(line);
        StringBuffer stringBuffer = new StringBuffer(line);
        for (int i = 0; i < line.length(); i++) {
            if (Character.isLetter(line.charAt(i))) {
                stringBuffer.setCharAt(i, Character.toUpperCase(line.charAt(i)));
                break;
            }
        }
        return stringBuffer.toString().trim();
    }

    //must have dot at the end of text.
    public static String lastAddDot(String line) {
        if (line.endsWith(".")) {
            return line;
        } else {
            return line + ".";
        }
    }

    ////check line empty
    public static boolean isLineEmpty(String line) {
        if (line.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    //count number line of file
    public static int countLine(String pathFile) {
        try {
            File file = new File(pathFile);
            //check path file is file or not
            if (file.isFile()) {
                RandomAccessFile raf;
                raf = new RandomAccessFile(file, "r");
                int countLine = 0;
                String line = raf.readLine();
                while (line != null) {
                    countLine++;
                    line = raf.readLine();
                }
                return countLine;
            } else {
                System.err.println("Not is file");
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static void changeOneLine(String pathFile, int numberLine, int countLine) {
        try {
            File file = new File(pathFile);
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            FileChannel fileChanel = raf.getChannel();
            raf.seek(raf.getFilePointer());
            String line = raf.readLine();
            //loop until last paragraph
            int len = (int) (raf.length() - raf.getFilePointer());
            byte[] bytearray = new byte[len];
            raf.readFully(bytearray, 0, len);
            fileChanel.truncate(0);
            raf.write(bytearray, 0, len);
            //check line empty
            if (isLineEmpty(line)) {
                return;
            }
            //there are no blank line between lines
            line = Manager.formatOneSpace(line);
            line = Manager.formatSpecialCharacters(line);
            line = Manager.firstAfterDotUpperCase(line);
            line = Manager.noSpaceQuotes(line);
            //if first line first character of word in first line is in Uppercase
            if (numberLine == 0) {
                line = firstUpercase(line);
            }
            //must have dot at the end of text.
            if (numberLine == countLine - 1) {
                line = lastAddDot(line);
            }

            raf.seek(file.length());
            raf.writeBytes(System.getProperty("line.separator")
                    + line);
            raf.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
