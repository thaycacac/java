
import java.util.*;
import java.io.*;

public class CountCoins {

    public static void main(String[] args) throws FileNotFoundException {
        File source = new File("D:\\FPT University\\FALL 2021\\LAB211\\Source.txt");
        // Scanner for an input file
        Scanner fileIn = new Scanner(source);
        CountCoins(fileIn);
    }

    public static void CountCoins(Scanner fileIn) {
        // constant pair
        ArrayList<Pair<String, Integer>> arr = new ArrayList<Pair<String, Integer>>();
        arr.add(new Pair<String, Integer>("pennies", 1));
        arr.add(new Pair<String, Integer>("nickels", 5));
        arr.add(new Pair<String, Integer>("dimes", 10));
        arr.add(new Pair<String, Integer>("quarters", 25));

        // variables
        double dollars;
        int cents = 0;

        // convert to string to process
        String s = "";
        while (fileIn.hasNext()) {
            s += fileIn.nextLine();
        }

        System.out.println(s);
        // case-insensitively
        s = s.toLowerCase();
        s += " "; // match for algorithms

        // temporary variables
        int length = s.length();
        char tmpChar;
        String tmpString;
        int quantity = 0;

        // process
        for (int i = 0; i < length; i++) {
            tmpString = "";
            tmpChar = s.charAt(i);

            // take number
            while (tmpChar >= '0' && tmpChar <= '9') {
                tmpString += tmpChar;
                tmpChar = s.charAt(++i);
            }

            if (!tmpString.isEmpty()) {
                try {
                    quantity = Integer.parseInt(tmpString);
                } catch (Exception e) {
                    // TODO: handle exception
                    System.err.println("Can't convert from string to int");
                    break;
                }
            }

            // take String
            if (tmpChar >= 'a' && tmpChar <= 'z') {
                for (Pair<String, Integer> p : arr) {
                    if (p.getKey().charAt(0) == tmpChar) {
                        cents += p.getValue() * quantity;
                    }
                }
                while (tmpChar >= 'a' && tmpChar <= 'z') {
                    tmpChar = s.charAt(++i);
                }
            }
        }

        dollars = 1.0 * cents / 100;
        System.out.println("Total money: $" + dollars);
    }
}
