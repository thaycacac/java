/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Data.SalaryHistory;
import Data.Worker;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hailiang194
 */
public class Input {

    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    /**
     * input integer
     *
     * @param msg prompt
     * @param MIN minimum value of input
     * @param MAX maximum value of input
     * @return inputted integer
     * @throws java.io.Exception IO exception occur or input is out of range
     */
    public static int inputInterger(String msg, final int MIN, final int MAX) throws Exception {
        System.out.print(msg);
        int input = Integer.parseInt(in.readLine());

        if ((input < MIN) || (input > MAX)) {
            throw new Exception(String.format("Input is out of range, input=%d, range = [%d, %d]", input, MIN, MAX));
        }

        return input;
    }

    /**
     * display option and input, note Object should be enumerate
     *
     * @param options
     * @return selected value
     */
    public static Object inputOption(Object[] options) {
        Object option;
        while (true) {
            try {
                System.out.println("1. Add worker");
                System.out.println("2. Up salary");
                System.out.println("3. Down salary");
                System.out.println("4. Display Information salary");
                System.out.println("5. Exit");

                option = options[inputInterger("Choose option: ", 1, options.length) - 1];
                break;
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

        return option;
    }

    /**
     * input double with range (MIN, MAX)
     *
     * @param msg prompt
     * @param MIN minimum value
     * @param MAX maximum value
     * @return inputted double
     * @throws java.lang.Exception when input is out of range
     */
    public static double inputDouble(String msg, final double MIN, final double MAX) throws IOException, Exception, NumberFormatException {
        System.out.print(msg);
        double input = Double.parseDouble(in.readLine());

        if ((Double.compare(input, MIN) <= 0) || (Double.compare(input, MAX) >= 0)) {
            throw new Exception(String.format("Input is out of range: input=%.2f, range=(%.2f,%.2f)", input, MIN, MAX));
        }

        return input;
    }

    /**
     * input a string
     *
     * @param msg prompt
     * @return inputted string
     * @throws IOException when IO exception occur
     */
    public static String inputString(String msg) throws IOException {
        System.out.print(msg);
        return in.readLine();
    }

    /**
     * input code
     *
     * @param msg prompt
     * @return inputted code
     * @throws IOException when IO Exception occur
     * @throws Exception when code in invalid
     */
    public static String inputCode(String msg) throws IOException, Exception {
        String input = inputString(msg);

        if (!InputValidation.isValidCode(input)) {
            throw new Exception("Invalid code");
        }

        return input;
    }

    /**
     * input worker
     *
     * @param msg prompt
     * @return inputted worker
     */
    public static Worker inputWorker(String msg) {
        System.out.println(msg);

        String code = null;
        while (true) {
            try {
                code = inputCode("Enter code: ");
                if (Data.manager.WorkerManager.getInstance().findByCode(code) != null) {
                    System.out.println(code + "has been exist!\nTry again.");
                    continue;
                }
                break;
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
        String name = null;
        while (true) {
            try {
                name = inputString("Enter name: ");
                break;
            } catch (IOException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
        int age = 0;
        while (true) {
            try {
                age = inputInterger("Enter age: ", 1, 200);
                break;
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

        double salary = 0.0;
        while (true) {
            try {
                salary = inputDouble("Enter salary: ", 0.0, Double.POSITIVE_INFINITY);
                break;
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

        String workLocation = null;
        while (true) {
            try {
                workLocation = inputString("Enter work location:");
                break;
            } catch (IOException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

        Worker worker = new Worker(code, name, age, workLocation);

        worker.updateSalary(new SalaryHistory(salary, new Date(System.currentTimeMillis())));

        return worker;
    }

    /**
     * hold the screen until user press Enter
     */
    public static void hold() {
        try {
            in.readLine();
        } catch (IOException ex) {
        }
    }
}
