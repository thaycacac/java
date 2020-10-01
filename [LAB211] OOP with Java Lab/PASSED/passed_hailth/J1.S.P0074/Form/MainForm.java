/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Matrix.operator.Addition;
import Matrix.operator.Multiplication;
import Matrix.operator.Subtraction;

/**
 *
 * @author hailiang194
 */
public class MainForm extends Form {

    enum OPTION {
        ADDITION, SUBTRACTION, MULTIPLICATION, EXIT
    };

    @Override
    public void setup() {

    }

    @Override
    protected EXIT_STATUS update() {

        System.out.println("=============== Calculator Program ================");

        OPTION option = (OPTION) Input.inputOption(OPTION.values());

        Form nextForm = null;
        switch (option) {
            case ADDITION:
                nextForm = new OperationForm("-------- ADDITION --------", '+', new Addition());
                break;
            case SUBTRACTION:
                nextForm = new OperationForm("--------- SUBTRACTION ----------", '-', new Subtraction());
                break;
            case MULTIPLICATION:
                nextForm = new OperationForm("--------- MULTIPLICATION -------", '*', new Multiplication());
                break;
            case EXIT:
                System.exit(0);
        }
        
        nextForm.setup();
        nextForm.loop();
        
        Input.hold();

        return EXIT_STATUS.UPDATE_EXIT;
    }

}
