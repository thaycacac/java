/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileDisplay;

import java.io.File;

/**
 *
 * @author hailiang194
 */
public abstract class FileDisplay {

    private int count;

    public FileDisplay() {
        this.count = 0;
    }

    
    
    /**
     * check if file is displayed
     *
     * @param file
     * @return true if file is displayed, otherwise false
     */
    public abstract boolean isDisplayedFile(File file);

    public int getCount() {
        return count;
    }
    
    

    public void display(File file) {
        if (file.isFile()) {
            if (this.isDisplayedFile(file)) {
                System.out.println(file);
                count++;
            }

            return;
        }

        File[] children = file.listFiles();
        for (File child : children) {
            display(child);
        }
    }

}
