/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Data.fileIO.SalaryFileSaver;
import Data.fileIO.WorkerFileSaver;


/**
 *
 * @author hailiang194
 */
public class AddWorkerForm extends Form{

    @Override
    public void setup() {
        
    }

    @Override
    protected EXIT_STATUS update() {
        Data.manager.WorkerManager manager = Data.manager.WorkerManager.getInstance();
        
        try {
            manager.insert(Input.inputWorker("--------------- Add Worker -----------------"));
            
            WorkerFileSaver workerSaver = new WorkerFileSaver(Data.Data.WORKER_PATH);
            workerSaver.append(manager);
            
            SalaryFileSaver salarySaver = new SalaryFileSaver(Data.Data.SALARY_PATH);
            salarySaver.append(manager.get(manager.size() - 1));
            
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        
        
        return EXIT_STATUS.LOOP_EXIT;
    }
    
}
