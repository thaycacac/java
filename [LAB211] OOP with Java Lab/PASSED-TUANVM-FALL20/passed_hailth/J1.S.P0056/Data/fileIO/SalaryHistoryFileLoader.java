/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.fileIO;

import Data.Worker;
import Data.manager.WorkerManager;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author hailiang194
 */
public class SalaryHistoryFileLoader implements IFileLoadable {

    private Data.manager.WorkerManager manager;
    private String path;

    private static SalaryHistoryFileLoader instance = new SalaryHistoryFileLoader(Data.manager.WorkerManager.getInstance(), Data.Data.SALARY_PATH);

    private SalaryHistoryFileLoader(WorkerManager manager, String path) {
        this.manager = manager;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public static SalaryHistoryFileLoader getInstance() {
        return instance;
    }

    @Override
    public void load() throws Exception {
        Data.formatter.SalaryHistoryFileFormatter formatter = new Data.formatter.SalaryHistoryFileFormatter();
        BufferedReader reader = new BufferedReader(new FileReader(this.path));

        String line = null;
        while ((line = reader.readLine()) != null) {
            String code = line.substring(0, line.indexOf(formatter.DELIM));

            Worker worker = this.manager.findByCode(code);

            if (worker == null) {
                throw new Exception(code + "is not exist in worker manager");
            }

            String data = line.substring(line.indexOf(formatter.DELIM) + 1);
            worker.updateSalary(formatter.formatFrom(data));
        }
    }

}
