/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import FileDisplay.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hailiang194
 */
public class GreaterSizeForm extends Form {

    @Override
    public void setup() {

    }

    @Override
    protected EXIT_STATUS update() {
        System.out.println("---------- Get file name with type java ------------");

        long size = 0;
        while (true) {
            try {
                size = Input.inputSize("Enter size: ");
                break;
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

        String path = null;
        while (true) {
            try {
                path = Input.inputPath("Enter path: ");
                break;
            } catch (IOException ex) {
                System.out.println("ERROR : " + ex.getMessage());
            }
        }

        File file = new File(path);

        if (!file.exists()) {
            System.out.println("Path doesn't exist");
            return EXIT_STATUS.LOOP_EXIT;
        }

        GreaterSizeFileDisplay display = new GreaterSizeFileDisplay(size);

        display.display(file);
        System.out.println("Total: " + display.getCount());
        
        return EXIT_STATUS.LOOP_EXIT;
    }

}
