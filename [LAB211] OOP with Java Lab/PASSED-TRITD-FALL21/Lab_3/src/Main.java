
import java.util.Scanner;

public class Main {

    private static Scanner SC = new Scanner(System.in);

    public static String Reverse(String input) {
        String reverse = "";

        String[] words = input.split("\\s+");

        for (int i = words.length - 1; i >= 0; i--) {
            reverse += words[i] + " ";
        }

        reverse = reverse.substring(0);

        return reverse.trim();
    }

    public static void main(String[] args) {
        do {
            System.out.print("Please enter a string: ");
            String input = SC.nextLine().trim();
            if (!input.isEmpty()) {
                String output = Reverse(input);
                System.out.println("String After Reverse: " + output);
                break;
            } else {
                //show error mess if user enter empty sring
                System.err.println("Please enter a non-empty string!");
            }
        } while (true);
    }
}
