/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.fileIO;

import Data.manager.WorkerManager;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author hailiang194
 */
public class WorkerFileLoader implements IFileLoadable {

    private Data.manager.WorkerManager manager;
    private String path;

    private static WorkerFileLoader instance = new WorkerFileLoader(Data.manager.WorkerManager.getInstance(), Data.Data.WORKER_PATH);

    private WorkerFileLoader(WorkerManager manager, String path) {
        this.manager = manager;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public static WorkerFileLoader getInstance() {
        return instance;
    }

    @Override
    public void load() throws Exception {
        Data.formatter.WorkerFileFormatter formatter = new Data.formatter.WorkerFileFormatter();
        BufferedReader reader = new BufferedReader(new FileReader(this.path));

        String line = null;
        while ((line = reader.readLine()) != null) {
            manager.insert(formatter.formatFrom(line));
        }
    }

}
