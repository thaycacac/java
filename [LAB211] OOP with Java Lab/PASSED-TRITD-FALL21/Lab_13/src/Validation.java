
import java.util.Scanner;

public class Validation {

    private static final Scanner in = new Scanner(System.in);

    //check user input number limit
    public int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input string
    public String checkInputPathFile() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    //check user input double
    public double checkInputMoney() {
        //loop until user input corect
        System.out.print("Enter money: ");
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input double");
                System.out.print("Enter again: ");
            }
        }
    }
     protected static String checkInputString() {
        while (true) {
            try {
                String result = in.nextLine();
                if (result.isEmpty()) {
                    throw new NullPointerException();
                }
                return result;
            } catch (NullPointerException n) {
                System.out.print("Enter again: ");
                System.out.println("Please input string!");
            }
        }
    }
}
