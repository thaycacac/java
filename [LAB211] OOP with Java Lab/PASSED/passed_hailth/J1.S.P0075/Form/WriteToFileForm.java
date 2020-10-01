/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hailiang194
 */
public class WriteToFileForm extends Form{

    @Override
    public void setup() {
    
    }

    @Override
    protected EXIT_STATUS update() {
        
        String content = null;
        while(true)
        {
            try {
                content = Input.inputContent("Enter content: ");
                break;
            } catch (IOException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
        
        String path = null;
        while (true) {
            try {
                path = Input.inputPath("Enter path: ");
                break;
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
            writer.append(content);
            writer.close();
            System.out.println("Write done");
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        
        return EXIT_STATUS.LOOP_EXIT;
    }
    
}
