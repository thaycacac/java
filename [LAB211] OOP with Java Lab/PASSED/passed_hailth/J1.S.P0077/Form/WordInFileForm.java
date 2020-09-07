/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import FileFinder.WordFoundLister;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author hailiang194
 */
public class WordInFileForm extends Form{

    @Override
    public void setup() {
    
    }

    @Override
    public EXIT_OPTION update() {
        System.out.println("------------------ Count Word ---------------------");
        String path = null;
        while (true) {
            try {
                path = Input.inputString("Enter path: ");
                break;
            } catch (IOException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

        File file = new File(path);
        
        String word = null;
        while (true) {
            try {
                word = Input.inputString("Enter word: ");
                break;
            } catch (IOException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
        
        WordFoundLister lister = new WordFoundLister(word, file);
        
        System.out.println("--------------- File Name ----------------");
        
        for (File found : lister.find()) {
            System.out.println(found.getAbsolutePath());
        }
        
        return EXIT_OPTION.LOOP_EXIT;
    }
    
}
