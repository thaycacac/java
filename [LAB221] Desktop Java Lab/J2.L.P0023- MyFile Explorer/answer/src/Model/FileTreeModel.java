package Model;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.io.File;

public class FileTreeModel implements TreeModel {
    // We specify the root directory when we create the model.
    protected Node root;
    public FileTreeModel(Node root) { this.root = root; }

    // The model knows how to return the root object of the tree
    public Object getRoot() { return root; }

    // Tell JTree whether an object in the tree is a leaf or not
    public boolean isLeaf(Object node) {  return ((Node)node).getParent().isFile(); }

    // Tell JTree how many children a node has
    public int getChildCount(Object parent) {
//        System.out.println(((Node) parent).getParent().getPath());
        File[] children = ((Node)parent).getParent().listFiles();
        
        if(root.getParent().getPath().equals(((Node)parent).getParent().getPath())){
            int count =0;
            for(File chil:children){
                if(chil.getName().equals("")) count++;
            }
            return count;
        }
//        System.out.println(children.length);
        if (children == null) return 0;
        return children.length;
    }

    // Fetch any numbered child of a node for the JTree.
    // Our model returns File objects for all nodes in the tree.  The
    // JTree displays these by calling the File.toString() method.
    public Node getChild(Object parent, int index) {
        File[] children = ((Node)parent).getParent().listFiles();
//        System.out.println((children[index]).getPath());
        if ((children == null) || (index >= children.length)) return null;
        Node node=null;
        File f= children[index];
        if(root.getParent().getPath().equals(((Node)parent).getParent().getPath())){
            f= children[index+7];
        }
        if(f.getName().equals("")){
            return new Node(f,f.getPath());
        }else{
            return new Node(f);
        }
//        System.out.println(node.getParent().getPath());
    }

    // Figure out a child's position in its parent node.
    public int getIndexOfChild(Object parent, Object child) {
        File[] children = ((Node)parent).getParent().listFiles();
        if (children == null) return -1;
        String childname = ((File)child).getName();
        for(int i = 0; i < children.length; i++) {
            if (childname.equals((children[i]).getName())) return i;
        }
        return -1;
    }

    // This method is only invoked by the JTree for editable trees.
    // This TreeModel does not allow editing, so we do not implement
    // this method.  The JTree editable property is false by default.
    public void valueForPathChanged(TreePath path, Object newvalue) {}

    // Since this is not an editable tree model, we never fire any events,
    // so we don't actually have to keep track of interested listeners.
    public void addTreeModelListener(TreeModelListener l) {}
    public void removeTreeModelListener(TreeModelListener l) {}
}
