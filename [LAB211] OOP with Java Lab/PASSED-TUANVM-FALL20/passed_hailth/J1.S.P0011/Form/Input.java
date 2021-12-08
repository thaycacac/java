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

    enum FORM_BASE {
        BINARY, DECIMAL, HEXADECIMAL
    };

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
     * Input convert number
     * @param msg prompt
     * @return inputted number in String
     * @throws IOException IO Exception occur
     */
    public static String inputConvertNumber(String msg) throws IOException {
        System.out.print(msg);
        return in.readLine();
    }

    /**
     * input base in form
     * @param msg prompt
     * @return base
     */
    public static int inputBase(String msg) {
        FORM_BASE[] bases = FORM_BASE.values();

        for (int i = 0; i < bases.length; i++) {
            System.out.println(String.valueOf(i + 1) + ". " + bases[i]);
        }
        FORM_BASE base;
        while (true) {
            try {
                base = bases[inputInterger(msg, 1, bases.length) - 1];
                break;
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
        
        switch(base)
        {
            case BINARY:
                return 2;
            case DECIMAL:
                return 10;
            case HEXADECIMAL:
                return 16;
        }

        return -1; //for Java error
    }
}
