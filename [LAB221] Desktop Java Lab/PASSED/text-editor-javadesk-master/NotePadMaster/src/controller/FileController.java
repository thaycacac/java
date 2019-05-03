package controller;

import form.MainForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Sharp team
 */
public class FileController {

    // controller file
    public void controller(MainForm mainForm) {
        JFileChooser chooser = new JFileChooser();

        setupFileChoose(chooser);
        newFile(mainForm, chooser);
        openFile(mainForm, chooser);
        saveFile(mainForm, chooser);
        saveAsFile(mainForm, chooser);
        exitNote(mainForm, chooser);
        checkClose(mainForm, chooser);

        checkSaved(mainForm);
    }

    // setup file chooser
    private void setupFileChoose(JFileChooser chooser) {
        // allow user choose file .java 
        chooser.addChoosableFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().endsWith(".java");
                }
            }

            @Override
            public String getDescription() {
                return "Java Source File(*.java)";
            }
        });

        // allow user choose file .txt
        chooser.addChoosableFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().endsWith(".txt");
                }
            }

            @Override
            public String getDescription() {
                return "Text Files(*.txt)";
            }
        });

        // set current directory
        chooser.setCurrentDirectory(new File("."));

    }

    // allow user save file
    private void saveFile(MainForm mainForm, JFileChooser chooser) {
        mainForm.getFileSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeTextAreaToFile(mainForm, chooser);
                mainForm.setSaved(true);
            }
        });
    }

    // allow user save file as
    private void saveAsFile(MainForm mainForm, JFileChooser chooser) {
        mainForm.getFileSaveAs().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check user continue or cancel
                if (checkSave(mainForm, chooser)) {
                    return;
                }
                saveAsToFile(mainForm, chooser);
            }
        });
    }

    // allow user openfile
    private void openFile(MainForm mainForm, JFileChooser chooser) {
        mainForm.getFileOpen().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check user continue or cancel
                if (checkSave(mainForm, chooser)) {
                    return;
                }
                // loop until user click file .txt or .java 
                File fileCheck = null;
                while (true) {
                    chooser.showOpenDialog(mainForm);
                    fileCheck = chooser.getSelectedFile();
                    if (fileCheck.exists()) {
                        break;
                    }
                    JOptionPane.showMessageDialog(mainForm, "File not found", "Open", JOptionPane.INFORMATION_MESSAGE);
                }
                mainForm.setFile(fileCheck);
                // clear text area
                mainForm.getTxtArea().setText("");
                // write content file to text area
                writeFileToTextArea(mainForm);
                mainForm.setSaved(true);
            }
        });
    }

    // create new file
    private void newFile(MainForm mainForm, JFileChooser chooser) {
        mainForm.getFileNew().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check user continue or cancel
                if (checkSave(mainForm, chooser)) {
                    return;
                }
                mainForm.getTxtArea().setText("");
            }
        });
    }

    // exit app
    private void exitNote(MainForm mainForm, JFileChooser chooser) {
        mainForm.getFileExit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check user continue or cancel
                if (checkSave(mainForm, chooser)) {
                    return;
                }
                System.exit(0);
            }
        });
    }

    // write file from file to text area
    public void writeFileToTextArea(MainForm mainForm) {
        try {
            //TODO check save file old
            FileInputStream fin = new FileInputStream(mainForm.getFile());
            BufferedReader din = new BufferedReader(new InputStreamReader(fin));
            String str = "";
            while (str != null) {
                str = din.readLine();
                if (str == null) {
                    break;
                }
                mainForm.getTxtArea().append(str + "\n");
            }
            // when user open, not change then file save
            mainForm.setTextCheckSaved(mainForm.getTxtArea().getText());
            mainForm.setSaved(true);
            mainForm.getTxtArea().setCaretPosition(0);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // write text area to file
    private void writeTextAreaToFile(MainForm mainForm, JFileChooser chooser) {
        FileWriter fout = null;
        try {
            if (mainForm.getFile() == null) {
                saveAsToFile(mainForm, chooser);
                return;
            }
            fout = new FileWriter(mainForm.getFile());
            fout.write(mainForm.getTxtArea().getText());
            mainForm.setTextCheckSaved(mainForm.getTxtArea().getText());
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fout.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // save as write to file
    private void saveAsToFile(MainForm mainForm, JFileChooser chooser) {
        File checkFile = null;
        while (true) {
            chooser.showSaveDialog(mainForm);
            checkFile = chooser.getSelectedFile();
            if (!checkFile.exists()) {
                break;
            }
            int option = JOptionPane.showConfirmDialog(mainForm, "Do you want to replace it?", "Save As", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                break;
            }
        }
        mainForm.setFile(checkFile);
        mainForm.setTextCheckSaved("");
        writeTextAreaToFile(mainForm, chooser);
    }

    // check change saved
    private void checkSaved(MainForm mainForm) {
        mainForm.getTxtArea().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                if (!mainForm.getTxtArea().getText().equals(mainForm.getTextCheckSaved())) {
                    mainForm.setSaved(false);
                }
            }
        });
    }

    // check user choose yes or no or cancel in dialog
    private boolean checkSave(MainForm mainForm, JFileChooser chooser) {
        String message = "<html><div style = 'color:blue'>Do you want to save the changes to file </div><html>";
        // check user choose yes or no
        boolean checkSaved = mainForm.isSaved();
        if (checkSaved == false) {
            int x = JOptionPane.showConfirmDialog(mainForm, message, "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
            if (x == JOptionPane.YES_OPTION) {
                if (mainForm.getFile() == null) {
                    saveAsToFile(mainForm, chooser);
                } else {
                    writeTextAreaToFile(mainForm, chooser);
                }
            }
            //// user click close when x == -1 
            if (x == JOptionPane.CANCEL_OPTION || x == -1) {
                return true;
            }
        }
        return false;
    }

    // check user want to close or not
    private void checkClose(MainForm mainForm, JFileChooser chooser) {
        mainForm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainForm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                String message = "<html><div style = 'color:blue'>Do you want to save the changes to file </div><html>";
                // check user choose yes or no
                boolean checkSaved = mainForm.isSaved();
                if (checkSaved == false) {
                    int x = JOptionPane.showConfirmDialog(mainForm, message, "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (x == JOptionPane.YES_OPTION) {
                        if (mainForm.getFile() == null) {
                            saveAsToFile(mainForm, chooser);
                        } else {
                            writeTextAreaToFile(mainForm, chooser);
                        }
                    }
                    // user click close
                    if (x == JOptionPane.CANCEL_OPTION) {
                        return;
                    }
                    // user click no
                    if (x == JOptionPane.NO_OPTION) {
                        System.exit(0);
                    }
                } else {
                    System.exit(0);
                }
            }
        });
    }
}
