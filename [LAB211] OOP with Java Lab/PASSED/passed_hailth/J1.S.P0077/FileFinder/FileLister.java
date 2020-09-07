/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileFinder;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author hailiang194
 */
public abstract class FileLister {

    protected final File parent;
    protected ArrayList<File> foundchildren;

    public FileLister(File parent) {
        this.parent = parent;
        this.foundchildren = new ArrayList<>();
    }

    public abstract boolean isFoundFile(File file);

    protected void list(File file) {
        if (!file.exists()) {
            return;

        }
        
        if (file.isFile()) {
            if (this.isFoundFile(file)) {
                this.foundchildren.add(file);
            }

            return;
        }

        File[] children = file.listFiles();
        for (File child : children) {
            list(child);
        }
    }

    public ArrayList<File> find() {
        if (!this.foundchildren.isEmpty()) {
            this.foundchildren = new ArrayList<>();
        }

        list(this.parent);

        return this.foundchildren;
    }

}
