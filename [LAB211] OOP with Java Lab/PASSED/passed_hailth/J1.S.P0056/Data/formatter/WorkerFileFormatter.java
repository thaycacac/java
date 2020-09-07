/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.formatter;

import Data.Worker;
import java.util.StringTokenizer;

/**
 *
 * @author hailiang194
 */
public class WorkerFileFormatter implements IFormatable<Worker>{

    public final String DELIM = ":";
    
    @Override
    public String formatTo(Worker e) {
        return e.getCode() + DELIM + e.getName() + DELIM + String.valueOf(e.getAge()) + DELIM + e.getWorkLocation();
    }

    @Override
    public Worker formatFrom(String e) throws Exception {
        StringTokenizer token = new StringTokenizer(e, DELIM);
        
        String code = token.nextToken().trim();
        String name = token.nextToken().trim();
        int age = Integer.parseInt(token.nextToken().trim());
        String workLocation = token.nextToken().trim();
        
        return new Worker(code, name, age, workLocation);
    }
    
}
