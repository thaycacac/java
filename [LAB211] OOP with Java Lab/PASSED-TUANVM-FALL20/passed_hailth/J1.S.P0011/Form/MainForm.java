/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import BaseConverter.BaseConverter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hailiang194
 */
public class MainForm extends Form {

    @Override
    public void setup() {

    }

    @Override
    protected EXIT_STATUS update() {
        System.out.println("=============== BASE CONVERTER ===================");

        int original = Input.inputBase("Choose original base: ");
        int convert = Input.inputBase("Choose convert base: ");

        BaseConverter converter = null;
        try {
            converter = new BaseConverter(original, convert);
        } catch (Exception ex) {
            System.out.println("ERROR" + ex.getMessage());
        }

        String number = null;
        while (true) {
            try {
                number = Input.inputConvertNumber("Enter number: ");
                break;
            } catch (IOException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

        try {
            System.out.println(number + "(" + converter.getOrginalBase() + ") = " + converter.convert(number) + "(" + converter.getConvertBase() + ")");
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }

        int option = 0;

        while (true) {
            try {
                option = Input.inputYesNoOption("Do you want to continue?(1/0): ");
                break;
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

        switch (option) {
            case Input.YES_OPTION:
                return EXIT_STATUS.UPDATE_EXIT;
            case Input.NO_OPTION:
                return EXIT_STATUS.LOOP_EXIT;
        }

        return EXIT_STATUS.UPDATE_EXIT;
    }

}
