
import java.io.*;
import java.util.*;

public class FlipLines {

    public static void main(String[] args) {
        File inputFile = new File("D:\\FPT University\\FALL 2021\\LAB211\\input.txt");
        // a Scanner for an input file
        try {
            Scanner fileIn = new Scanner(inputFile);
            flipLines(fileIn);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void flipLines(Scanner fileIn) {
        String[] repo = new String[1000];
        int index = 0;

        while (fileIn.hasNextLine()) {
            repo[index++] = fileIn.nextLine();
        }

        for (int i = 0; i < index; i++) {
            System.out.println(repo[i]);
        }

        // if the number of lines is odd, increase the number of lines by 1
        if (index % 2 != 0) {
            repo[index] = repo[index - 1];
            repo[index - 1] = "";
        }

        System.out.println("\n------------------OUTPUT-----------------------\n");
        // Algorithms
        for (int i = 0; i < index; i += 2) {
            System.out.println(repo[i + 1]);
            System.out.println(repo[i]);
        }

    }
}
