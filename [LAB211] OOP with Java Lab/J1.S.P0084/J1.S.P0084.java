
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author THAYCACAC
 */
 /*
 Title 
  	Large number 
 Background 
	Process with big data is common problem in the real world. Let’s start with big data now.

	Program Specifications
	Write an application to multiply two digit number inputted from keyboard then display result to screen.
	Note: size of inputted number is unlimited
Guidelines
	Try to use array to store the result and two digit number.

 */
public class Main {

    public static String checkInput() {
        String pattern = "\\d+";
        while (true) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Not empty!!!");
                continue;
            }
            if (!input.matches(pattern)) {
                System.err.println("Only number!!!");
                continue;
            }
            return input;
        }
    }

    public static void main(String[] args) {
        String numOne = checkInput();
        String numTwo = checkInput();
        BigInteger bigNumOne = new BigInteger(numOne);
        BigInteger bigNumTwo = new BigInteger(numTwo);
        System.out.println(bigNumOne.multiply(bigNumTwo));
    }
}
