
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author THAYCACAC
 */
public class Main {
//Check

    public static int checkIntLimit(int min, int max) {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Re-input!!!");
            }

        }
    }

    public static String checkString() {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                String str = in.nextLine().trim();
                if (str.length() == 0) {
                    throw new NumberFormatException();
                }
                return str;
            } catch (NumberFormatException e) {
                System.err.println("Not empty!!!");
            }
        }
    }
//End Check

    public static void zipFile() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Source Folder: ");
        String pathSrc = checkString();
        System.out.print("Enter Destination Folder: ");
        String pathCompress = checkString();
        System.out.print("Enter Name: ");
        String fileZipName = in.nextLine();

        boolean check = compressTo(pathSrc, fileZipName, pathCompress);
        if (check == true) {
            System.out.println("Successfully");
        } else {
            System.out.println("Fail");
        }
    }

    public static boolean compressTo(String pathSrc, String fileZipName,
            String pathCompress) throws FileNotFoundException, IOException {
//        String sourceFile = "D:/Test2/FileName1.txt";
        String sourceFile = pathSrc;
        String nameFos = pathCompress + "/" + fileZipName + ".zip";
//        FileOutputStream fos = new FileOutputStream("D:/Test/FileZip.zip");
        FileOutputStream fos = new FileOutputStream(nameFos);
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        File fileToZip = new File(sourceFile);
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);
        final byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        zipOut.close();
        fis.close();
        fos.close();
        return true;
    }

    public static void unzipFile() throws IOException {
        System.out.print("Enter Source file: ");
        String pathZipFile = checkString();
        System.out.print("Enter Destination Folder: ");
        String pathExtract = checkString();
        boolean check = extractTo(pathZipFile, pathExtract);
        if (check == true) {
            System.out.println("Successfully");
        } else {
            System.out.println("Fail");
        }
    }

    public static boolean extractTo(String pathZipFile, String pathExtract) throws FileNotFoundException, IOException {
//        String fileZip = "D:/Test/FileZip.zip";
        String fileZip = pathZipFile;
        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            String fileName = zipEntry.getName();
//            File newFile = new File("D:/Test/" + fileName);
            File newFile = new File(pathExtract + fileName);
            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.close();
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
        return true;
    }

    public static void printMain() throws IOException {
        while (true) {
            System.out.println("1. Compression");
            System.out.println("2. Extraction");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choose = checkIntLimit(1, 3);
            switch (choose) {
                case 1:
                    zipFile();
                    break;
                case 2:
                    unzipFile();
                    break;
                case 3:
                    return;
            }
        }
    }
//End Check

    public static void main(String[] args) throws IOException {
        printMain();
    }
}
