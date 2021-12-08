/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import TextCounter.TextCounter;
import java.io.IOException;

/**
 *
 * @author hailiang194
 */
public class MainForm extends Form {

    @Override
    public void setup() {

    }

    @Override
    public EXIT_OPTION update() {

        String content = null;

        while (true) {
            try {
                content = Input.inputString("Enter the content:\n");
                break;
            } catch (IOException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
        
        TextCounter counter = new TextCounter(content);
        counter.count();
        
        System.out.println(counter.getWords());
        System.out.println(counter.getCharacters());
                
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
                return EXIT_OPTION.UPDATE_EXIT;
            case Input.NO_OPTION:
                return EXIT_OPTION.LOOP_EXIT;
        }

        return EXIT_OPTION.UPDATE_EXIT;
    }
}
