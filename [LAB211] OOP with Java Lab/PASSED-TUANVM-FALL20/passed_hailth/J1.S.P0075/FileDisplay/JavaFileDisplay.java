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
public class JavaFileDisplay extends FileDisplay{

    @Override
    public boolean isDisplayedFile(File file) {
        return file.getAbsolutePath().endsWith(".java");
    }
    
}
