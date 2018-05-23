
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author THAYCACAC
 */
public class Main {

    public static void main(String[] args) {
//        String pathFile = Manager.checkInputFileName();
        String pathFile = "D:/test.txt";
        StringBuffer content = new StringBuffer();
        try {
            File file = new File(pathFile);
            //check user input is file or not
            if (file.isFile()) {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = bufferedReader.readLine();
                //loop until last paragraph
                while (line != null) {
                    //there are no blank line between lines
                    if (line.equals("")) {
                        line = bufferedReader.readLine();
                        continue;
                    }
                    line = Manager.formatOneSpace(line);
                    line = Manager.formatSpecialCharacters(line);
                    line = Manager.firstAfterDotUpperCase(line);
                    line = Manager.noSpaceQuotes(line);
                    line = Manager.noSpaceApostrophe(line);
                    content.append(line);
                    content.append("\n");
                    line = bufferedReader.readLine();
                }
                fileReader.close();
                bufferedReader.close();

                Manager.writeFiler(pathFile, Manager.formatConten(content));
            } else {
                System.err.println("Not is file.");
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
