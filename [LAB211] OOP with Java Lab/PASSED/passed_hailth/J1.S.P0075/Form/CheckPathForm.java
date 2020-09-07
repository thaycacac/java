/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hailiang194
 */
public class CheckPathForm extends Form{

    @Override
    public void setup() {
    
    }

    @Override
    protected EXIT_STATUS update() {
        
        System.out.println("--------- Check path ---------------");
        String path = null;
        while(true)
        {
            try {
                path = Input.inputPath("Enter path: ");
                break;
            } catch (IOException ex) {
                System.out.println("ERROR : " + ex.getMessage());
            }
        }
        
        File file = new File(path);
        
        if(!file.exists())
        {
            System.out.println("Path doesn't exist");
        }
        else if(file.isFile())
        {
            System.out.println("Path to file");
        }
        else if(file.isDirectory())
        {
            System.out.println("Path to directory");
        }
        
        return EXIT_STATUS.LOOP_EXIT;
    }
    
}
