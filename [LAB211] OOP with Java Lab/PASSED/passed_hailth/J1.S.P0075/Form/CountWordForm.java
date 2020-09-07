/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


/**
 *
 * @author hailiang194
 */
public class CountWordForm extends Form {

    @Override
    public void setup() {

    }

    @Override
    protected EXIT_STATUS update() {

        String path = null;
        while (true) {
            try {
                path = Input.inputPath("Enter path: ");
                break;
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            return EXIT_STATUS.LOOP_EXIT;
        }
        
        
        int count = 0;
        String line = null;
        while(true)
        {
            try {
                line = reader.readLine();
            } catch (IOException ex) {
                System.out.println("ERROR: " + ex.getMessage());
                break;
            }
            
            if(line == null)
                break;
            
            StringTokenizer token = new StringTokenizer(line, " \t");
            while(token.hasMoreTokens())
            {
                token.nextToken();
                count++;
            }
        }
        
        System.out.println("Total: " + count);

        return EXIT_STATUS.LOOP_EXIT;
    }

}
