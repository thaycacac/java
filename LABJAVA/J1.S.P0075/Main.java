
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THAYCACAC
 */
public class Main {

    private static final Scanner in = new Scanner(System.in);

    private static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    private static String checkInputString() {
        while (true) {
            try {
                String result = in.nextLine().trim();
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Not empty");
            }
        }
    }

    private static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Size is digit");
            }
        }
    }

    private static void checkPath() {
        System.out.print("Enter path: ");
        String path = checkInputString();
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            System.out.println("Path to File.");
        } else if (file.exists() && file.isDirectory()) {
            System.out.println("Path to Directory");
        } else {
            System.out.println("Path doesn't exist");
        }
    }

    private static void getAllFileNameJavaInDirectory() {
        ArrayList<String> listFileName = new ArrayList<>();
        System.out.print("Enter path: ");
        String path = checkInputString();
        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            File[] listFile = file.listFiles();
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isFile() && listFile[i].getName().endsWith(".java")) {
                    listFileName.add(listFile[i].getName());
                }
            }
        } else {
            System.out.println("Path doesn't exist");
            return;
        }
        System.out.println("Result " + listFileName.size() + " file!");
        for (int i = 0; i < listFileName.size(); i++) {
            System.out.println(listFileName.get(i));
        }
    }

    private static void getFileWithSizeGreaterThanInput() {
        System.out.print("Enter size: ");
        int size = checkInputInt();
        System.out.print("Enter path: ");
        String path = checkInputString();

        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            File[] listFile = file.listFiles();
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isFile() && listFile[i].length() > size) {
                    System.out.println(listFile[i].getName());
                }
            }
        } else {
            System.out.println("Path doesn't exist");
            return;
        }
    }

    private static void appendContentToFile() throws IOException {
        System.out.print("Enter content: ");
        String content = checkInputString();
        System.out.print("Enter path: ");
        String path = checkInputString();
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(content);
            writer.close();
            System.out.println("Write done");
        } else {
            System.out.println("Path doesn't exist");
        }
    }

    private static void countCharacter() throws FileNotFoundException, IOException {
        System.out.print("Enter path: ");
        String path = checkInputString();
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            int count = 0;
            while (line != null) {
                String[] parts = line.split(" ");
                for (String w : parts) {
                    count++;
                }
                line = reader.readLine();
            }
            System.out.println("Total: " + count);
        } else {
            System.out.println("Path doesn't exist");
        }
    }

    private static void display() throws IOException {
        while (true) {
            System.out.println("1. Check Path");
            System.out.println("2. Get file name with type java");
            System.out.println("3. Get file with size greater than input");
            System.out.println("4. Write more content to file");
            System.out.println("5. Read file and count characters");
            System.out.println("6. Exit");
            System.out.print("Please choice one option: ");
            int choice = checkIntLimit(1, 6);
            switch (choice) {
                case 1:
                    checkPath();
                    break;
                case 2:
                    getAllFileNameJavaInDirectory();
                    break;
                case 3:
                    getFileWithSizeGreaterThanInput();
                    break;
                case 4:
                    appendContentToFile();
                    break;
                case 5:
                    countCharacter();
                    break;
                case 6:
                    return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        display();
    }
}
