/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileFinder;

import java.io.File;

/**
 *
 * @author hailiang194
 */
public class WordFoundLister extends FileLister{

    private String word;

    public WordFoundLister(String word, File parent) {
        super(parent);
        this.word = word;
    }
        
    @Override
    public boolean isFoundFile(File file) {
        FileFinder finder = new FileFinder(file);
        
        return finder.contain(this.word);
    }
    
}
