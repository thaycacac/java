/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Data.Worker;
import Data.formatter.WorkerDisplayFormatter;

/**
 *
 * @author hailiang194
 */
public class DisplayForm extends Form{

    @Override
    public void setup() {
    
    }

    @Override
    protected EXIT_STATUS update() {
        Data.formatter.WorkerDisplayFormatter formatter = new Data.formatter.WorkerDisplayFormatter();
        
        System.out.println(WorkerDisplayFormatter.HEADER);
        
        System.out.println("----------------------------------------------------");
        
        for (Worker worker : Data.manager.WorkerManager.getInstance()) {
            System.out.println(formatter.formatTo(worker));
        }
        
        return EXIT_STATUS.LOOP_EXIT;
    }
    
}
