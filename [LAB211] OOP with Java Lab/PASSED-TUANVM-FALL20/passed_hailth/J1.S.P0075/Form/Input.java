/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
                System.out.println("1. Check path");
                System.out.println("2. Check file name with type java");
                System.out.println("3. Get file with size greater than input");
                System.out.println("4. Write more content to file");
                System.out.println("5. Read file and count characters");
                System.out.println("6. Exit");

                option = options[inputInterger("Choose option: ", 1, options.length) - 1];
                break;
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

        return option;
    }

    /**
     * input path
     *
     * @param msg prompt
     * @return inputted path
     * @throws IOException IO Exception occur
     */
    public static String inputPath(String msg) throws IOException {
        return inputContent(msg);
    }

    public static String inputContent(String msg) throws IOException {
        System.out.print(msg);
        return in.readLine();
    }

    /**
     * hold the screen until user press Enter
     */
    public static void hold() {
        try {
            in.readLine();
        } catch (Exception e) {
        }
    }

    /**
     * input file size
     *
     * @param msg prompt
     * @return inputted size
     * @throws Exception
     */
    public static long inputSize(String msg) throws Exception {
        System.out.print(msg);
        long input = Long.parseLong(in.readLine());

        if (input < 0) {
            throw new Exception(String.format("Input is out of range, input=%d, range = [0, %d]", input, Long.MAX_VALUE));
        }

        return input;
    }
}
