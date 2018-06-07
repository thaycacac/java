package Manager;

import java.util.Scanner;

/**
 *
 * @author THAYCACAC
 */
public class Manager {

    private static final Scanner in = new Scanner(System.in);

    //display menu
    public static int mennu() {
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = checkInputIntLimit(1, 3);
        return choice;
    }

    //check user input number limit
    public static int checkInputIntLimit(int min, int max) {
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

    //allow user input number double
    public static double checkInputDouble() {
        //loop until user input correct
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

    //allow user input operator
    public static String checkInputOperator() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
            } else if (result.equalsIgnoreCase("+") || result.equalsIgnoreCase("-")
                    || result.equalsIgnoreCase("*") || result.equalsIgnoreCase("/")
                    || result.equalsIgnoreCase("^") || result.equalsIgnoreCase("=")) {
                return result;
            } else {
                System.err.println("Please input (+, -, *, /, ^)");
            }
            System.out.print("Enter again: ");
        }
    }

    //allow user input number
    public static double inputNumber() {
        System.out.print("Enter number: ");
        double number = checkInputDouble();
        return number;
    }

    //allow user calculator normal
    public static void normalCalculator() {
        double memory;
        System.out.print("Enter number: ");
        memory = checkInputDouble();
        while (true) {
            System.out.print("Enter operator: ");
            String operator = checkInputOperator();
            if (operator.equalsIgnoreCase("+")) {
                memory += inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("-")) {
                memory -= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("*")) {
                memory *= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("/")) {
                memory /= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("^")) {
                memory = Math.pow(memory, inputNumber());
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("=")) {
                System.out.println("Result: " + memory);
                return;
            }
        }

    }

    //display result BMI status
    public static String BMIStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard.";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard.";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight.";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat-should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }

    //allow user BMI calculator
    public static void BMICalculator() {
        System.out.print("Enter Weight(kg): ");
        double weight = checkInputDouble();
        System.out.print("Enter Height(cm): ");
        double height = checkInputDouble();
        double bmi = weight*10000 / (height*height);
        System.out.printf("BMI number: %.2f\n", bmi);
        System.out.println("BMI Status: " + BMIStatus(bmi));
    }
}
