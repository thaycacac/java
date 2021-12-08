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
public class GreaterSizeFileDisplay extends FileDisplay {

    private final long LIMIT_KB;
    private final long KB_PER_BYTE = 1024;

    public GreaterSizeFileDisplay(long LIMIT_KB) {
        this.LIMIT_KB = LIMIT_KB;
    }
    

    @Override
    public boolean isDisplayedFile(File file) {
        return (file.length() > (this.LIMIT_KB * KB_PER_BYTE));
    }

}
