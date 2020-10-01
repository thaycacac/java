/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Data.SalaryHistory;
import Data.Worker;
import Data.fileIO.SalaryFileSaver;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hailiang194
 */
public class UpSalaryForm extends Form {

    @Override
    public void setup() {

    }

    @Override
    protected EXIT_STATUS update() {
        String code = null;
        while (true) {
            try {
                code = Input.inputCode("Enter code: ");
                break;
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

        Data.manager.WorkerManager manager = Data.manager.WorkerManager.getInstance();
        Worker worker = manager.findByCode(code);

        if (worker == null) {
            System.out.println(code + "hasn't been exist!");
            return EXIT_STATUS.LOOP_EXIT;
        }

        double salary = 0.0;
        while (true) {
            try {
                salary = Input.inputDouble("Enter salary: ", worker.getCurrentSalary(), Double.POSITIVE_INFINITY);
                break;
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
        
        worker.updateSalary(new SalaryHistory(salary, new Date(System.currentTimeMillis())));
        
        SalaryFileSaver saver = new SalaryFileSaver(Data.Data.SALARY_PATH);
        try {
            saver.append(worker);
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }

        return EXIT_STATUS.LOOP_EXIT;
    }

}
