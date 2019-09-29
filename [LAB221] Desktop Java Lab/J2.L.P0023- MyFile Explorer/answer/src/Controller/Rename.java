package Controller;

import Model.Node;
import View.MyFileBrowserFrame;
import View.RenameDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class Rename {

    public Rename(MyFileBrowserFrame mainFrame, RenameDialog findFrame) {
        findKeyword(mainFrame, findFrame);
        cancelFind(findFrame);
        checkEmptyFind(mainFrame, findFrame);
    }

    // set action when ok botton clicked
    public void findKeyword(MyFileBrowserFrame mainFrame, RenameDialog findFrame) {
        String pathParent = ((Node) mainFrame.getTree().getLastSelectedPathComponent()).getParent().getParent();
        String oldName = ((Node) mainFrame.getTree().getLastSelectedPathComponent()).getParent().getName();

        findFrame.getTxtFind().setText(oldName);
        findFrame.getFindButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newName= findFrame.getTxtFind().getText();
                //check oldname equal newname to rename
                if (!oldName.equals(newName)) {
                    mainFrame.setFileRename(new File(pathParent + "/" + findFrame.getTxtFind().getText()));
                    mainFrame.setRename(true);
                }

                findFrame.setVisible(false);
            }
        });
    }


    //when user click button cancel
    public void cancelFind(RenameDialog findFrame) {
        findFrame.getCancelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findFrame.setVisible(false);
            }
        });
    }

    //check user not input
    public void checkEmptyFind(MyFileBrowserFrame mainFrame, RenameDialog findFrame) {
        findFrame.getTxtFind().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String oldName = ((Node) mainFrame.getTree().getLastSelectedPathComponent()).getParent().getName();
                if (findFrame.getTxtFind().getText().trim().isEmpty()||findFrame.getTxtFind().getText().equals(oldName)) {
                    findFrame.getFindButton().setEnabled(false);
                } else {
                    findFrame.getFindButton().setEnabled(true);
                }
            }
        });
    }
}
