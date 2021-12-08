/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
     * @param MIN minimum value
     * @param MAX maximum value
     * @return inputted value
     * @throws Exception
     */
    public static int inputInteger(String msg, final int MIN, final int MAX) throws Exception {
        System.out.print(msg);

        int input = Integer.parseInt(in.readLine());

        if ((input < MIN) || (input > MAX)) {
            throw new Exception(String.format("Input is out of range input=%d, range=[%d, %d]", input, MIN, MAX));
        }

        return input;
    }

    /**
     * input a string
     *
     * @param msg prompt
     * @return inputted string
     * @throws IOException
     */
    public static String inputString(String msg) throws IOException {
        System.out.print(msg);
        return in.readLine();
    }

    /**
     * hold until user press Enter
     */
    public static void hold() {
        try {
            in.readLine();
        } catch (Exception e) {
        }
    }

    /**
     * Choose an option
     * @param options array of options
     * @return chosen option
     */
    public static Object inputOption(Object[] options) {
        System.out.println("1. Count Word In File");
        System.out.println("2. Find File By Word");
        System.out.println("3. Exit");

        Object option = null;

        while (true) {
            try {
                option = options[inputInteger("Choose an option:", 1, options.length) - 1];
                break;
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

        return option;
    }
}
