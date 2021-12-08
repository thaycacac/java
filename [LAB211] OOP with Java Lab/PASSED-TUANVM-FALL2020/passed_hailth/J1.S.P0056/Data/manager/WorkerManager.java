/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.manager;

import Data.Worker;
import java.util.ArrayList;

/**
 *
 * @author hailiang194
 */
public class WorkerManager extends ListWorkers implements IFind<Worker>, IInsert<Worker> {

    private static WorkerManager instance = new WorkerManager();

    public static WorkerManager getInstance() {
        return instance;
    }

    @Override
    public Worker findFirst(IIdentify<Worker> identify) {
        for (Worker worker : this.workers) {
            if (identify.isFound(worker)) {
                return worker;
            }
        }

        return null;
    }

    @Override
    public ArrayList<Worker> findAll(IIdentify<Worker> indetify) {
        ArrayList<Worker> found = new ArrayList<>();

        for (Worker worker : this.workers) {
            if (indetify.isFound(worker)) {
                found.add(worker);
            }
        }

        return found;
    }

    /**
     * find worker by code
     * @param code worker code
     * @return worker, null If not found
     */
    public Worker findByCode(String code) {
        return findFirst(new IIdentify<Worker>() {
            @Override
            public boolean isFound(Worker e) {
                return e.getCode().equals(code);
            }
        });
    }

    @Override
    public void insert(Worker e) throws Exception {
        if(this.findByCode(e.getCode()) != null) //found
            throw new Exception("Worker's code has been exist.");
        
        this.workers.add(e);
    }


}
