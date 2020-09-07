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

    public static final int YES_OPTION = 1;
    public static final int NO_OPTION = 0;

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
     * input yes no with 1 for yes , 0 for no
     *
     * @param msg prompt
     * @return option
     * @throws Exception IO exception occur or invalid input
     */
    public static int inputYesNoOption(String msg) throws Exception {
        return inputInterger(msg, NO_OPTION, YES_OPTION);
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
}
