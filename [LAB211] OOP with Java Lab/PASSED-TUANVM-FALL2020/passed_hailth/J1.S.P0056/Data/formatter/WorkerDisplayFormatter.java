/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.formatter;

import Data.Worker;
import java.text.SimpleDateFormat;

/**
 *
 * @author hailiang194
 */
public class WorkerDisplayFormatter implements IFormatable<Worker>{

    public static final String HEADER = "Code       Name Age Salary   Status Date";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    
    @Override
    public String formatTo(Worker e) {
        double salaryDiff = e.getCurrentSalaryDifference();
        int status = Double.compare(salaryDiff, 0.0);
        
        String STATUS = (status > 0) ? "UP" : ((status == 0) ? "SAME" : "DOWN");
        
        return String.format("%4s %10s %3d %-10.2f %-4s %s", 
                e.getCode(),
                e.getName(),
                e.getAge(),
                e.getCurrentSalary(),
                STATUS,
                dateFormatter.format(e.getCurrentSalaryUpdatedDate()));
    }

    @Override
    public Worker formatFrom(String e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
