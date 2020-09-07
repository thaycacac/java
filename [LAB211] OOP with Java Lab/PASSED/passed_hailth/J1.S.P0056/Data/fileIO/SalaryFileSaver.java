/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.fileIO;

import Data.Worker;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author hailiang194
 */
public class SalaryFileSaver implements IFileSavable<Data.Worker>{
    private String path;

    public SalaryFileSaver(String path) {
        this.path = path;
    }

    @Override
    public void append(Worker container) throws Exception {
        Data.formatter.SalaryHistoryFileFormatter formatter = new Data.formatter.SalaryHistoryFileFormatter();
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.path, true));
        writer.append(container.getCode() + formatter.DELIM + formatter.formatTo(container.getLastestSalary()) + '\n');
        writer.close();
    }
    
    
}
