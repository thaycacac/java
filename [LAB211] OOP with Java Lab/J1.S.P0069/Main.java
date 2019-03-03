
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author THAYCACAC
 */
public class Main {

    private static final Scanner in = new Scanner(System.in);

    private static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    private static String checkInputString() {
        while (true) {
            String result = in.nextLine();
            if (result.length() == 0) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    private static boolean checkInputYN() {
        while (true) {
            String result = in.nextLine();
            if (result.length() == 1 && result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.length() == 1 && result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Re-input.");
        }
    }

    private static void writeFile() {
        System.out.print("Please enter file path: ");
        String path = checkInputString();
        File file = new File(path);
        if (file.isFile()) {
            try {
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                System.out.print("Please enter file content: ");
                String content = checkInputString();
                bufferedWriter.write(content);
                bufferedWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (file.isDirectory()) {
            try {
                file.createNewFile();
                System.out.println("Create file done.");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Path not is file or directory");
        }
    }

    private static void readFile() {
        System.out.print("Do you want to read file? (Y/N or y/n): ");
        if (checkInputYN()) {
            System.out.print("Please enter file path: ");
            String path = checkInputString();
            File file = new File(path);
            if (file.isFile()) {
                String readline;
                try {
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    while ((readline = bufferedReader.readLine()) != null) {
                        System.out.println(readline);
                    }

                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private static void display() {
        System.out.print("Do you want to write file? (Y/N or y/n): ");
        if (checkInputYN()) {
            writeFile();
            readFile();
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        display();
    }
}
