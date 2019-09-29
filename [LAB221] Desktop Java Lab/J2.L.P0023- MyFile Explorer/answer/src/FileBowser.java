import Controller.Tree;
import View.MyFileBrowserFrame;

public class FileBowser {
    public static void main(String[] args) {
        MyFileBrowserFrame myFileBrowserFrame = new MyFileBrowserFrame("File Browser");
        myFileBrowserFrame.setVisible(true);
        Tree tree = new Tree(myFileBrowserFrame);
    }
}
