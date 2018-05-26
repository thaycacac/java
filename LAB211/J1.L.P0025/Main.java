
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THAYCACAC
 */
public class Main {

    public static void changeOneLine(String pathFile) {
        try {
            File file = new File(pathFile);
            //check user input is file or not

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
            //there are no blank line between lines
            line = Manager.formatOneSpace(line);
            line = Manager.formatSpecialCharacters(line);
            line = Manager.firstAfterDotUpperCase(line);
            line = Manager.noSpaceQuotes(line);
            line = Manager.noSpaceApostrophe(line);
            
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

    public static void main(String[] args) {
//        changeOneLine("d:/test.txt");

        try {
            File file = new File("d:/test.txt");
            RandomAccessFile raf;
            raf = new RandomAccessFile(file, "r");
            int countLine = 0;
            String line = raf.readLine();
            while (line != null) {
                countLine++;
                line = raf.readLine();
            }
            for (int i = 0; i < countLine; i++) {
                changeOneLine("d:/test.txt");
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

//        String pathFile = Manager.checkInputFileName();
    }
}
