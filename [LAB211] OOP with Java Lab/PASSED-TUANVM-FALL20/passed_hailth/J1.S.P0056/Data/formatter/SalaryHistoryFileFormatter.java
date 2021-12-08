/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.formatter;

import Data.SalaryHistory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

/**
 *
 * @author hailiang194
 */
public class SalaryHistoryFileFormatter implements IFormatable<SalaryHistory>{
    final public String DELIM = ":";
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    @Override
    public String formatTo(SalaryHistory e) {
        return String.format("%.2f", e.getSalary()) + DELIM + this.dateFormat.format(e.getUpdatedDate());
    }

    @Override
    public SalaryHistory formatFrom(String e) throws Exception{
        StringTokenizer token = new StringTokenizer(e, DELIM);
        
        double salary = Double.parseDouble(token.nextToken().trim());
        Date updatedDate = this.dateFormat.parse(token.nextToken().trim());
        
        return new SalaryHistory(salary, updatedDate);
    }
    
    
}
