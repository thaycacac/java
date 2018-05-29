
/**
 *
 * @author THAYCACAC
 */
public class Main {

    public static void main(String[] args) {
        String pathFile = Manager.checkInputFileName();
        int countLine = Manager.countLine(pathFile);
        for (int i = 0; i < countLine; i++) {
            Manager.changeOneLine(pathFile, i, countLine);
        }

    }
}
