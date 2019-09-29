package View;

import Model.FileTreeModel;
import Model.Node;

import javax.swing.*;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.io.File;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;

public class MyFileBrowserFrame extends JFrame {

    private Node root;
    private JTree tree;
    private TreePath selectionPath;
    private int[] rowPath;
    private FileTreeModel model;
    private JTextArea contains;
    private JTextField txtStatus;
    private JPopupMenu rightClickMenu;

    private JMenuItem copy;
    private JMenuItem paste;
    private JMenuItem move;
    private JMenuItem reName;

    private boolean isPaste = false;
    private boolean isMove = false;
    private boolean isRename = false;
    private boolean isReload = false;
    private File fileCopy;
    private File fileMove;
    private File fileRename;

    private FileSystemView fileSystemView;

    public MyFileBrowserFrame(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        fileSystemView = FileSystemView.getFileSystemView();
        File[] roots = fileSystemView.getRoots();
        File fileRootNode = null;
        for (File fileSyFile : roots) {
                System.out.println(fileSyFile.getPath());
                File[] files = fileSystemView.getFiles(fileSyFile, true);
                fileRootNode= files[0];
//                DefaultMutableTreeNode node = new DefaultMutableTreeNode(fileRoot);
//                root.add(node);
//                //show children node
////                File[] files = fileSystemView.getFiles(fileSyFile, true);
////                root.add(new DefaultMutableTreeNode(files[0]));
//                for (File file : fileRoot.listFiles()) {
//                    node.add(new DefaultMutableTreeNode(file));
//                }
            }
        root = new Node(fileRootNode,"System");
        // Create a TreeModel object to represent our tree of files
        model = new FileTreeModel(root);

        // Create a JTree and tell it to display our model
        tree = new JTree();
        tree.setShowsRootHandles(true);
        tree.setModel(model);

        // The JTree can get big, so allow it to scroll.
        JScrollPane scrollpane = new JScrollPane(tree);

        // Display it all in a window and make the window appear
        getContentPane().setLayout(new BorderLayout());
        scrollpane.setPreferredSize(new Dimension(400, 500));
        getContentPane().add(scrollpane, BorderLayout.WEST);

        contains = new JTextArea();
        contains.setText("<<Contents>>");
        contains.setEditable(false);
        contains.setPreferredSize(new Dimension(200, 500));
        getContentPane().add(contains, BorderLayout.CENTER);

        txtStatus = new JTextField();
        txtStatus.setEditable(false);
        txtStatus.setText("Open Windows");
        getContentPane().add(txtStatus, BorderLayout.NORTH);

        rightClickMenu = new JPopupMenu("Edit");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        move = new JMenuItem("Move");
        reName = new JMenuItem("Rename");
        paste.setEnabled(false);
        rightClickMenu.add(copy);
        rightClickMenu.add(paste);
        rightClickMenu.add(move);
        rightClickMenu.add(reName);
        tree.add(rightClickMenu);

        pack();
    }

    public JTree getTree() {
        return tree;
    }

    public JTextArea getContains() {
        return contains;
    }

    public JTextField getTxtStatus() {
        return txtStatus;
    }

    public JMenuItem getCopy() {
        return copy;
    }

    public JMenuItem getPaste() {
        return paste;
    }

    public JMenuItem getMove() {
        return move;
    }

    public JMenuItem getReName() {
        return reName;
    }

    public JPopupMenu getRightClickMenu() {
        return rightClickMenu;
    }

    public boolean isPaste() {
        return isPaste;
    }

    public void setPaste(boolean paste) {
        isPaste = paste;
    }

    public File getFileCopy() {
        return fileCopy;
    }

    public void setFileCopy(File fileCopy) {
        this.fileCopy = fileCopy;
    }

    public boolean isMove() {
        return isMove;
    }

    public void setMove(boolean move) {
        isMove = move;
    }

    public File getFileMove() {
        return fileMove;
    }

    public void setFileMove(File fileMove) {
        this.fileMove = fileMove;
    }

    public File getFileRename() {
        return fileRename;
    }

    public void setFileRename(File fileRename) {
        this.fileRename = fileRename;
    }

    public boolean isRename() {
        return isRename;
    }

    public void setRename(boolean rename) {
        isRename = rename;
    }

    public TreePath getSelectionPath() {
        return selectionPath;
    }

    public void setSelectionPath(TreePath selectionPath) {
        this.selectionPath = selectionPath;
    }

    public boolean isReload() {
        return isReload;
    }

    public void setReload(boolean reload) {
        isReload = reload;
    }

    public int[] getRowPath() {
        return rowPath;
    }

    public void setRowPath(int[] rowPath) {
        this.rowPath = rowPath;
    }
}
