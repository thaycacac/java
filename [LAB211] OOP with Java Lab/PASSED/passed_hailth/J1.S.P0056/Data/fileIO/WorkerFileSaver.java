/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.fileIO;

import Data.formatter.WorkerFileFormatter;
import Data.manager.WorkerManager;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author hailiang194
 */
public class WorkerFileSaver implements IFileSavable<Data.manager.WorkerManager>{
    private String path;

    public WorkerFileSaver(String path) {
        this.path = path;
    }

    @Override
    public void append(WorkerManager container) throws Exception {
        Data.formatter.WorkerFileFormatter formatter = new WorkerFileFormatter();
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.path, true));
        writer.append(formatter.formatTo(container.get(container.size() - 1)) + '\n');
        writer.close();
    }
}
