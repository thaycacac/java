package Controller;

import Model.FileTreeModel;
import Model.Node;
import View.MyFileBrowserFrame;
import View.RenameDialog;

import javax.swing.*;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Tree {

    private MyFileBrowserFrame myFileBrowserFrame;

    public Tree(MyFileBrowserFrame myFileBrowserFrame) {
        this.myFileBrowserFrame = myFileBrowserFrame;
        selectingNode();
        rightClick();
    }

    private void rightClick() {
        // set action when right click on the tree
        myFileBrowserFrame.getTree().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                File file = null;
                try {
                    file = new File(((Node) myFileBrowserFrame.getTree().getLastSelectedPathComponent()).getParent().getPath());

                    if (SwingUtilities.isRightMouseButton(e)) {
                        // check status is Copyed

                        if (!file.getPath().equals(((Node) myFileBrowserFrame.getTree().getModel().getRoot()).getParent().getPath())) {
                            if (file.isDirectory()) {
                                if (myFileBrowserFrame.isPaste()) {
                                    File fileCopy = myFileBrowserFrame.getFileCopy();
                                    if (file.getPath().equals(fileCopy.getPath())) {
                                        myFileBrowserFrame.getPaste().setEnabled(false);
                                    } else {
                                        if (file.getPath().startsWith(fileCopy.getPath())) {
                                            myFileBrowserFrame.getPaste().setEnabled(false);
                                        } else {
                                            myFileBrowserFrame.getPaste().setEnabled(true);
                                        }
                                    }
                                } else {
                                    myFileBrowserFrame.getPaste().setEnabled(false);
                                }
                            } else {
                                myFileBrowserFrame.getPaste().setEnabled(false);
                            }

                            // check status is "move" or "move to" to change text itemMenu
                            if (myFileBrowserFrame.isMove()) {
                                if (file.getPath().length() > 1) {
                                    File fileMove = myFileBrowserFrame.getFileMove();
                                    // check same folder or not
                                    if (file.getPath().equals(fileMove.getParent())) {
                                        myFileBrowserFrame.getMove().setEnabled(false);
                                    } else {
                                        //check move file is folder or file
                                        if (file.isDirectory()) {
                                            if (file.getPath().equals(fileMove.getPath())) {
                                                myFileBrowserFrame.getMove().setEnabled(false);
                                            } else {
                                                if (file.getPath().startsWith(fileMove.getPath())) {
                                                    myFileBrowserFrame.getMove().setEnabled(false);
                                                } else {
                                                    myFileBrowserFrame.getMove().setEnabled(true);
                                                }
                                            }
                                            myFileBrowserFrame.getMove().setText("Move to here");
                                        } else {
                                            myFileBrowserFrame.getMove().setEnabled(false);
                                            myFileBrowserFrame.getMove().setText("Move to here");
                                        }
                                    }
                                } else {
                                    myFileBrowserFrame.getMove().setEnabled(false);
                                }

                            } else {
                                if (file.getPath().length() > 3) {
                                    myFileBrowserFrame.getMove().setText("Move");
                                    myFileBrowserFrame.getMove().setEnabled(true);
                                } else {
                                    myFileBrowserFrame.getMove().setEnabled(false);
                                }
                            }

                            myFileBrowserFrame.getRightClickMenu().show(myFileBrowserFrame, e.getX(), e.getY());
                        }
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(myFileBrowserFrame, "Choose node of tree", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // set action when selectiong copy itemMenu in right click menu
        myFileBrowserFrame.getCopy().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFileBrowserFrame.setFileCopy(new File(((Node) myFileBrowserFrame.getTree().getLastSelectedPathComponent()).getParent().getPath()));
                myFileBrowserFrame.getTxtStatus().setText("Copy: " + myFileBrowserFrame.getFileCopy().toPath());
                myFileBrowserFrame.setPaste(true);
            }
        });

        // set action when selectiong paste itemMenu in right click menu
        myFileBrowserFrame.getPaste().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File folderPaster = ((Node) myFileBrowserFrame.getTree().getLastSelectedPathComponent()).getParent();

                File fileCopy = myFileBrowserFrame.getFileCopy();
                String pathParent = folderPaster.getPath();
                String nameFileCopy = fileCopy.getName();
                File filePaste = new File(pathParent + "/" + nameFileCopy);

                // check folder selected is same folder of file copy or not
                // is not same then copy file to folder selected
                // is same then add text "-Copy" to end of name file
                if (folderPaster.getPath().equals(fileCopy.getParent())) {
                    String newName = reNameFileExest(filePaste);
                    if (fileCopy.isFile()) {
                        try {
                            Files.copy(fileCopy.toPath(), new File(newName).toPath(), StandardCopyOption.REPLACE_EXISTING);
                            //reload the tree
                            TreePath treePath = myFileBrowserFrame.getSelectionPath();
                            int[] rowPath = myFileBrowserFrame.getRowPath();
                            reloadTree(myFileBrowserFrame, treePath, rowPath);
                        } catch (IOException e1) {
                            JOptionPane.showMessageDialog(myFileBrowserFrame, "Can't copy file!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        copyFolder(fileCopy, folderPaster);
                        //reload the tree
                        TreePath treePath = myFileBrowserFrame.getSelectionPath();
                        int[] rowPath = myFileBrowserFrame.getRowPath();
                        reloadTree(myFileBrowserFrame, treePath, rowPath);
                    }

                } else {
                    if (fileCopy.isFile()) {
                        if (filePaste.exists()) {
                            int replace = JOptionPane.showConfirmDialog(myFileBrowserFrame, "File is exist. Are you want replace???", "Replace?", JOptionPane.YES_NO_OPTION);
                            if (replace == JOptionPane.YES_OPTION) {
                                paste(fileCopy, filePaste);
                            }
                        } else {
                            paste(fileCopy, filePaste);
                        }
                    } else {
                        copyFolder(fileCopy, folderPaster);
                        //reload the tree
                        TreePath treePath = myFileBrowserFrame.getSelectionPath();
                        int[] rowPath = myFileBrowserFrame.getRowPath();
                        reloadTree(myFileBrowserFrame, treePath, rowPath);
                    }
                }
            }
        });

        // set action when move itemMenu in right click menu
        myFileBrowserFrame.getMove().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //check status is moving or not
                //is moving then action move
                //is not moving then enable move
                if (!myFileBrowserFrame.isMove()) {
                    myFileBrowserFrame.setFileMove(new File(((Node) myFileBrowserFrame.getTree().getLastSelectedPathComponent()).getParent().getPath()));
                    myFileBrowserFrame.getTxtStatus().setText("Move: " + myFileBrowserFrame.getFileMove().toPath());
                    myFileBrowserFrame.setMove(true);
                } else {
                    File folderPaster = ((Node) myFileBrowserFrame.getTree().getLastSelectedPathComponent()).getParent();

                    File fileCopy = myFileBrowserFrame.getFileMove();
                    String pathParent = folderPaster.getPath();
                    String nameFileCopy = fileCopy.getName();
                    File filePaste = new File(pathParent + "/" + nameFileCopy);

                    // check selected has choose is directory or file
                    // is directory then copy file to folder selected
                    // is file then so notification "copy fail"
                    if (fileCopy.isFile()) {
                        if (filePaste.exists()) {
                            int replace = JOptionPane.showConfirmDialog(myFileBrowserFrame, "File is exist. Are you want replace???", "Replace?", JOptionPane.YES_NO_OPTION);
                            if (replace == JOptionPane.YES_OPTION) {
                                move(folderPaster, fileCopy);
                            }
                        } else {
                            move(folderPaster, fileCopy);
                        }
                    } else {
                        copyFolder(fileCopy, folderPaster);
                        deleteFolder(fileCopy);
                        myFileBrowserFrame.setMove(false);
                        //reload the tree
                        TreePath treePath = myFileBrowserFrame.getSelectionPath();
                        int[] rowPath = myFileBrowserFrame.getRowPath();
                        reloadTree(myFileBrowserFrame, treePath, rowPath);
                    }
                }
            }
        });

        // set action when rename itemMenu in right click menu
        myFileBrowserFrame.getReName().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //show dialog enble input new name
                RenameDialog renameDialog = new RenameDialog(myFileBrowserFrame, true);
                renameDialog.getFindButton().setEnabled(false);
                Rename rename = new Rename(myFileBrowserFrame, renameDialog);
                renameDialog.setVisible(true);

                //check new name can rename
                if (myFileBrowserFrame.isRename()) {
                    File oldFile = ((Node) myFileBrowserFrame.getTree().getLastSelectedPathComponent()).getParent();
                    File newFile = myFileBrowserFrame.getFileRename();
                    if (newFile.exists()) {
                        JOptionPane.showMessageDialog(myFileBrowserFrame, "Can change new name", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        boolean success = oldFile.renameTo(newFile);

                        //check rename is succes or not
                        if (success) {
                            TreePath treePath = myFileBrowserFrame.getSelectionPath();
                            int[] rowPath = myFileBrowserFrame.getRowPath();
                            reloadTree(myFileBrowserFrame, treePath, rowPath);
                            myFileBrowserFrame.getTxtStatus().setText("Succes rename: " + myFileBrowserFrame.getFileRename().getPath());
                        } else {
                            myFileBrowserFrame.getTxtStatus().setText("Fail Rename: " + myFileBrowserFrame.getFileRename().getPath());
                        }
                    }

                    myFileBrowserFrame.setRename(false);
                }
            }
        });
    }

    private void paste(File fileCopy, File filePaste) {
        try {
            Files.copy(fileCopy.toPath(), filePaste.toPath(), StandardCopyOption.REPLACE_EXISTING);

            //reload the tree
            TreePath treePath = myFileBrowserFrame.getSelectionPath();
            int[] rowPath = myFileBrowserFrame.getRowPath();
            reloadTree(myFileBrowserFrame, treePath, rowPath);
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(myFileBrowserFrame, "Can't copy file!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void move(File folderPaster, File fileCopy) {
        try {
            Files.move(fileCopy.toPath(), new File(folderPaster.toPath() + "/" + fileCopy.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);

            TreePath treePath = myFileBrowserFrame.getSelectionPath();
            int[] rowPath = myFileBrowserFrame.getRowPath();
            reloadTree(myFileBrowserFrame, treePath, rowPath);

            myFileBrowserFrame.setMove(false);
        } catch (IOException e1) {
            myFileBrowserFrame.getTxtStatus().setText("Fail move: " + myFileBrowserFrame.getFileMove().getPath() + " To: " + folderPaster.getPath());
        }
    }

    // set action when node of tree is selected
    private void selectingNode() {

        //show contains of folder or file selected
        myFileBrowserFrame.getTree().addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                try {
                    Node nodeSelected = (Node) myFileBrowserFrame.getTree().getLastSelectedPathComponent();
                    myFileBrowserFrame.getContains().setText(showContains(nodeSelected));

                    if (nodeSelected.getParent().isDirectory()) {
                        myFileBrowserFrame.setSelectionPath(e.getPath());
                    }
                    myFileBrowserFrame.setRowPath(myFileBrowserFrame.getRowPath());
                    myFileBrowserFrame.getTxtStatus().setText("Selected: " + nodeSelected.getParent().getPath());

                } catch (NullPointerException ex) {
                    myFileBrowserFrame.getTxtStatus().setText("ERROR");
                }
            }
        });

        //set action when expand or collap note
        myFileBrowserFrame.getTree().addTreeExpansionListener(new TreeExpansionListener() {
            @Override
            public void treeExpanded(TreeExpansionEvent event) {
                myFileBrowserFrame.getTree().setSelectionPath(event.getPath());
            }

            @Override
            public void treeCollapsed(TreeExpansionEvent event) {
                myFileBrowserFrame.getTree().setSelectionPath(event.getPath());
            }
        });
    }

    private String showContains(Node node) {
        File parent = node.getParent();
        String content = "";

        //check node is directory or dile
        if (parent.isDirectory()) {
            String location = "Location: " + parent.getPath() + "\n";
            String size = "Size: " + folderSize(parent) + " (bytes)\n";
            int numSubFolders = 0;
            int numSubFile = 0;
            String[] children = parent.list();
            //count number of file and folder in directory selected
            if (children != null) {
                for (File f : parent.listFiles()) {
                    if (f.isDirectory()) {
                        numSubFolders++;
                    } else {
                        numSubFile++;
                    }
                }
            }
            String contains = "Contains: " + numSubFolders + " folders, " + numSubFile + " files \n";
            return location + size + contains;
        } else {
            String name = "Name: " + parent.getName() + "\n";
            String location = "Location: " + parent.getPath() + "\n";
            String size = "Size: " + parent.length() + " (bytes)\n";
            String extension = "Extension: " + parent.getPath().substring(parent.getPath().indexOf(".")) + "\n";
            return name + extension + location + size;
        }
    }

    // count size of folder selected
    private long folderSize(File directory) {
        myFileBrowserFrame.getContains().setText("Loading...");
        long size = 0;
        if (!myFileBrowserFrame.isReload()) {
            myFileBrowserFrame.getContains().setText("Counting...");
//            for (File file : directory.listFiles()) {
//                if (file.isFile()) {
//                    size += file.length();
//                } else {
//                    size += folderSize(file);
//                    System.out.println(file.getPath());
//                }
//            }
        }
        return size;
    }

    //reload the tree
    private void reloadTree(MyFileBrowserFrame myFileBrowserFrame, TreePath path, int[] rowPath) {
        myFileBrowserFrame.setReload(true);
        myFileBrowserFrame.getTree().setModel(new FileTreeModel(new Node(new File("."))));
        selectedByPath(myFileBrowserFrame.getTree(), path, "");
        myFileBrowserFrame.getTree().expandPath(myFileBrowserFrame.getTree().getSelectionPath());
        myFileBrowserFrame.setReload(false);
    }

    private void selectedByPath(JTree tree, TreePath path, String current) {
        for (int i = 1; i < tree.getRowCount(); i++) {
            tree.setSelectionRow(i);
            String pathCurrent = tree.getSelectionPath().toString();
            String firstString = pathCurrent.substring(0, pathCurrent.length() - 1);
            if (path.toString().startsWith(firstString) && (!pathCurrent.equals(current)) && (pathCurrent.startsWith(current))) {
                tree.expandRow(i);
                if (!path.toString().equals(pathCurrent)) {
                    selectedByPath(tree, path, pathCurrent);
                } else {
                    tree.expandRow(i);
                    return;
                }
            }
            if (tree.getSelectionPath().toString().equals(path.toString())) {
                break;
            }
        }
    }

    private String reNameFileExest(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                String parentFolder = file.getParent();
                String nameFile = file.getName();
                String newName = nameFile.substring(0, nameFile.lastIndexOf(".")) + "-Copy" + nameFile.substring(nameFile.lastIndexOf("."));
                return reNameFileExest(new File(parentFolder + "/" + newName));
            } else {
                String parentFolder = file.getParent();
                String nameFile = file.getName();
                String newName = nameFile + "-Copy";
                return reNameFileExest(new File(parentFolder + "/" + newName));
            }
        }
        return file.getPath();
    }

    private void copyFolder(File folderCopy, File folderPaste) {
        String nameCopy = folderCopy.getName();
        String pathPaste = folderPaste.getPath();
        File foPaste = new File(pathPaste + "/" + nameCopy);

        if (folderCopy.isDirectory()) {
            System.out.println("Folder: " + folderCopy.getPath());
            System.out.println("Folder: " + foPaste.getPath());

            if (!foPaste.exists()) {
                try {
                    Files.copy(folderCopy.toPath(), foPaste.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    System.out.println("DirectoryNotEmptyException");
                }
            } else {
                int replace = JOptionPane.showConfirmDialog(myFileBrowserFrame, "Folder is exist. Are you want replace???", "Replace?", JOptionPane.YES_NO_OPTION);
                if (replace == JOptionPane.NO_OPTION) {
                    try {
                        foPaste = new File(reNameFileExest(foPaste));
                        Files.copy(folderCopy.toPath(), foPaste.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            File[] listFile = folderCopy.listFiles();
            if (listFile.length > 0) {
                for (File f : listFile) {
                    copyFolder(f, foPaste);
                }
            } else {
                return;
            }
        } else {
            if (foPaste.exists()) {
                int replace = JOptionPane.showConfirmDialog(myFileBrowserFrame, "File is exist. Are you want replace???", "Replace?", JOptionPane.YES_NO_OPTION);
                if (replace == JOptionPane.YES_OPTION) {
                    try {
                        System.out.println("File: " + folderCopy.getPath());
                        System.out.println("File: " + foPaste.getPath());
                        Files.copy(folderCopy.toPath(), foPaste.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    Files.copy(folderCopy.toPath(), foPaste.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void moveFolder(File folderCopy, File folderPaste) {
        String nameCopy = folderCopy.getName();
        String pathPaste = folderPaste.getPath();
        File foPaste = new File(pathPaste + "/" + nameCopy);

        if (folderCopy.isDirectory()) {
            System.out.println("Folder: " + folderCopy.getPath());
            System.out.println("Folder: " + foPaste.getPath());

            if (!foPaste.exists()) {
                try {
                    Files.move(folderCopy.toPath(), foPaste.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    System.out.println("DirectoryNotEmptyException");
                }
            }

            File[] listFile = folderCopy.listFiles();
            if (listFile.length > 0) {
                for (File f : listFile) {
                    copyFolder(f, foPaste);
                }
            } else {
                return;
            }
        } else {
            if (foPaste.exists()) {
                int replace = JOptionPane.showConfirmDialog(myFileBrowserFrame, "File is exist. Are you want replace???", "Replace?", JOptionPane.YES_NO_OPTION);
                if (replace == JOptionPane.YES_OPTION) {
                    try {
                        System.out.println("File: " + folderCopy.getPath());
                        System.out.println("File: " + foPaste.getPath());
                        Files.move(folderCopy.toPath(), foPaste.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    Files.move(folderCopy.toPath(), foPaste.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void deleteFolder(File file) {
        File[] listFile = file.listFiles();
        for (File f : listFile) {
            if (f.isFile()) {
                System.out.println("File:" + f.getPath());
                try {
                    Files.delete(f.toPath());
                } catch (IOException e) {
                    System.out.println("Error delete: " + f.getPath());
                }
            } else {
                deleteFolder(f);
            }
        }

        System.out.println("Folder: " + file.getPath());
        try {
            Files.delete(file.toPath());
        } catch (IOException e) {
            System.out.println("Error delete" + file.getPath());
        }
        return;
    }
}
