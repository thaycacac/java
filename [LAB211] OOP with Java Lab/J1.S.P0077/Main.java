
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author THAYCACAC
 */
public class Main {

    private static final Scanner in = new Scanner(System.in);

    private static int checkInputLimit(int min, int max) {
        try {
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(in.nextLine());
            if (choice < min || choice > max) {
                throw new NumberFormatException();
            }
            return choice;
        } catch (NumberFormatException ex) {
            System.err.println("Re-input");
        }
        return 0;
    }

    private static int countWordInFile(String fileSource, String word) {
        FileReader fr = null;

        try {
            fr = new FileReader(fileSource);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int count = 0;
            while (line != null) {
                String[] parts = line.split(" ");
                for (String w : parts) {
                    if (w.equalsIgnoreCase(word)) {
                        count++;
                    }
                }
                line = br.readLine();
            }
            return count;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    private static void getFileNameContainsWordInDirectory(String source, String word) {
        File folder = new File(source);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                if (countWordInFile(file.getAbsolutePath(), word) != 0) {
                    System.out.println("file name: " + file.getName());
                }
            }
        }
    }

    public static void wordProgram() {
        String path;
        String word;
        while (true) {
            System.out.println("1. Count Word In File");
            System.out.println("2. Find File By Word");
            System.out.println("3. Exit");
            int choice = checkInputLimit(1, 3);
            switch (choice) {
                case 1:
                    System.out.print("Enter Path: ");
                    path = in.nextLine();
                    System.out.print("Enter Word: ");
                    word = in.nextLine();
                    int count = countWordInFile(path, word);
                    System.out.println("Count: " + count);
                    break;
                case 2:
                    System.out.print("Enter Path: ");
                    path = in.nextLine();
                    System.out.print("Enter Word: ");
                    word = in.nextLine();
                    getFileNameContainsWordInDirectory(path, word);
                    break;
                case 3:
                    return;
            }
        }
    }

    public static void main(String[] args) {
        wordProgram();
    }
}
