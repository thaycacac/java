package Model;

import java.io.File;

public class Node {
    private File parent;
    private String name="";

    public Node(File parent) {
        this.parent = parent;
    }

    public Node(File parent, String name) {
        this.parent = parent;
        this.name = name;
    }

    @Override
    public String toString() {
        if(name.equals("")){
        return parent.getName()+ "";
        }else{
            return name;
        }
    }

    public File getParent() {
        return parent;
    }
}
