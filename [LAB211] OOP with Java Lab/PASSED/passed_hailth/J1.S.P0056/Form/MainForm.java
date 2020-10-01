/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author hailiang194
 */
public class MainForm extends Form {

    enum OPTION {
        ADD_WORKER, UP_SALARY, DOWN_SALARY, DISPLAY, EXIT
    };

    @Override
    public void setup() {
        System.out.print("LOADING WORKER...");
        try {
            Data.fileIO.WorkerFileLoader.getInstance().load();
            System.out.println("DONE.");
        } catch (Exception ex) {
            System.out.println("FAIL.");
            System.out.println("ERROR: " + ex.getMessage());
            System.exit(0);
        }
        
        System.out.print("LOADING SALARY...");
        try {
            Data.fileIO.SalaryHistoryFileLoader.getInstance().load();
            System.out.println("DONE.");
        } catch (Exception ex) {
            System.out.println("FAIL.");
            System.out.println("ERROR: " + ex.getMessage());
            System.exit(0);
        }
    }

    @Override
    protected EXIT_STATUS update() {
        System.out.println("=========== Worker Manager ===============");

        OPTION option = (OPTION) Input.inputOption(OPTION.values());

        Form nextForm = null;
        switch (option) {
            case ADD_WORKER:
                nextForm = new AddWorkerForm();
                break;
            case UP_SALARY:
                nextForm = new UpSalaryForm();
                break;
            case DOWN_SALARY:
                nextForm = new DownSalaryForm();
                break;
            case DISPLAY:
                nextForm = new DisplayForm();
                break;
            case EXIT:
                System.exit(0);
        }
        
        nextForm.setup();
        nextForm.loop();
        
        System.out.println("Press Enter to continue");
        Input.hold();

        return EXIT_STATUS.UPDATE_EXIT;
    }

}
