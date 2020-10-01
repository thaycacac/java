/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Matrix.Matrix;
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
                for (int i = 0; i < options.length; ++i) {
                    System.out.println((i + 1) + ". " + options[i].toString());
                }

                option = options[inputInterger("Choose option: ", 1, options.length) - 1];
                break;
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

        return option;
    }

    /**
     * input double
     *
     * @param msg prompt
     * @return inputted double
     * @throws IOException IO exception occur
     */
    public static double inputDouble(String msg) throws IOException {
        System.out.print(msg);
        double input = Double.parseDouble(in.readLine());

        return input;
    }

    /**
     * input row and column then get the zeros matrix row x column
     *
     * @param msg prompt
     * @return inputted matrix
     */
    public static Matrix inputInitalizeMatrix(String msg) {
        System.out.println(msg);
        int row = 0;
        while (true) {
            try {
                row = inputInterger("Enter row: ", 1, Integer.MAX_VALUE);
                break;
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

        int column = 0;
        while (true) {
            try {
                column = inputInterger("Enter column: ", 1, Integer.MAX_VALUE);
                break;
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

        return new Matrix(row, column);
    }

    /**
     * input values for matrix
     *
     * @param matrix inputted matrix
     */
    public static void inputMatrixValues(Matrix matrix) {
        for (int r = 0; r < matrix.getRow(); ++r) {
            for (int c = 0; c < matrix.getColumn(); ++c) {
                double value = 0.0;
                while (true) {
                    try {
                        value = inputDouble("Enter matrix[" + r + "][" + c + "]: ");
                        break;
                    } catch (Exception ex) {
                        System.out.println("ERROR:" + ex.getMessage());
                    }
                    
                }

                matrix.setValueAt(r, c, value);
            }
        }
    }

    public static void hold() {
        try {
            in.readLine();
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}
