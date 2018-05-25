
import java.io.File;
import java.util.Scanner;

public class OpenFile {
    
    public static void openFile(File file) {
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                System.out.println(files[i].getName());
            } else if (files[i].isDirectory()) {
                openFile(files[i]);
            }
        }
    }
    
    public static void openFolder(File file) {
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                System.out.println(files[i].getName());
                openFolder(files[i]);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        File file = new File(path);
        openFolder(file);
    }
    
}
