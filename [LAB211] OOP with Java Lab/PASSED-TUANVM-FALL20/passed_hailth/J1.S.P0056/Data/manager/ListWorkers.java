/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.manager;

import Data.Worker;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author hailiang194
 */
public abstract class ListWorkers implements Iterable<Worker> {

    protected ArrayList<Worker> workers;

    public ListWorkers() {
        this.workers = new ArrayList<>();
    }

    public ListWorkers(ArrayList<Worker> workers) {
        this.workers = workers;
    }

    /**
     * get the number of workers in list
     *
     * @return the number of workers
     */
    public int size() {
        return this.workers.size();
    }

    /**
     * get the specific worker with index
     *
     * @param index worker's index in list
     * @return worker
     */
    public Worker get(int index) {
        return this.workers.get(index);
    }

    @Override
    public Iterator<Worker> iterator() {
        return this.workers.iterator();
    }


}
