
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MyCopy {

    void copy(String file, String folder) {
        File f1 = new File(file);
        File f2 = new File(folder);
        if (f1.exists() && f1.isFile() && f2.exists() && f2.isDirectory()) {
            try {
                FileInputStream fis = new FileInputStream(f1);
                FileOutputStream fos = new FileOutputStream(folder + "/" + f1.getName());
                int b;
                while ((b = fis.read()) != -1) {
                    fos.write(b);
                }
                fis.close();
                fos.close();
                System.out.println("One file compied to" + folder);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Checkout given file and folder");
        }
    }
    public static void main(String[] args) {
        MyCopy mc = new MyCopy();
        mc.copy("D:Lab10.txt", "E:/ADOBE");
    }
}
