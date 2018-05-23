
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
        int conditionBreak = strings.length;
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
        StringBuffer stringBuffer = new StringBuffer();
        line = line.toLowerCase();
        String[] strings = line.split("\\s+");
        //only one space between words
        for (int i = 0; i < strings.length; i++) {
            stringBuffer.append(strings[i]);
            stringBuffer.append(" ");
        }
        line = stringBuffer.toString().trim();
        line = formatOneSpaceSpecial(line, ".");
        line = formatOneSpaceSpecial(line, ",");
        line = formatOneSpaceSpecial(line, ":");
        line = formatOneSpaceSpecial(line, ";");
        line = formatOneSpaceSpecial(line, "'");
        line = formatOneSpaceSpecial(line, "?");
        line = formatOneSpaceSpecial(line, "!");
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
                    || stringBuffer.charAt(i + 1) == ':'
                    || stringBuffer.charAt(i + 1) == ';'
                    || stringBuffer.charAt(i + 1) == '?'
                    || stringBuffer.charAt(i + 1) == '!') {
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
    public static String noSpaceQuotes(String line) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strings = line.split(" \" ");
        for (int i = 0; i < strings.length; i++) {
            if (strings.length - 1 == i) {
                stringBuffer.append(strings[i]);
            } else if (i % 2 == 0) {
                stringBuffer.append(strings[i]);
                stringBuffer.append(" \"");
            } else {
                stringBuffer.append(strings[i]);
                if (i == strings.length) {

                }
                stringBuffer.append("\" ");
            }
        }
        return stringBuffer.toString().trim();
    }

    //there are no spaces before and after sentence or word phrases in quotes ('').
    public static String noSpaceApostrophe(String line) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strings = line.split("\\s+\'\\s+");
        int lengthWord = strings.length;
        for (int i = 0; i < lengthWord; i++) {
            if (strings.length - 1 == i) {
                stringBuffer.append(strings[i]);
            } else if (i % 2 == 0) {
                stringBuffer.append(strings[i]);
                stringBuffer.append(" \'");
            } else {
                stringBuffer.append(strings[i]);
                stringBuffer.append("\' ");
            }
        }
        return stringBuffer.toString().trim();
    }

    //must have dot at the end of text and first character of word in first line is in Uppercase.
    public static String formatConten(StringBuffer content) {
        int index = 0;
        //upercase until find letter
        while (true) {
            if (Character.isLetter(content.charAt(index))) {
                content.setCharAt(index, Character.toUpperCase(content.charAt(index)));
                break;
            }
            index++;
        }
        //add dot end content
        if (content.charAt(content.length() - 1) != '.') {
            content.append(".");
        }
        content.deleteCharAt(content.length() - 2);
        return content.toString();
    }

    public static void writeFiler(String pathFile, String content) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            bufferedWriter.close();
            fileWriter.close();
            System.err.println("Successful");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
