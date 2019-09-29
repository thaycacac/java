/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author hnamn
 */
public class Main {

    main f1;
    AddCourses f2;
    Search f3;
    Display f4;

    public Main(main f1, AddCourses f2, Search f3, Display f4) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.f4 = f4;
    }

    public boolean checkToAdd(ArrayList<course> cs, course c) {
        boolean flag = true;
        for (course c1 : cs) {
            if (c1.getCode().equals(c.getCode())) {
                flag = !flag;
            }
        }
        if (c.getName().length() < 6 || c.getCode().length() < 3 || c.getCredit().length() > 2) {
            flag = !flag;
        }
        try {
            Integer.parseInt(c.getCredit());
        } catch (Exception e) {
            flag = !flag;
        }
        return flag;
    }

    public void controller(ArrayList<course> cs) {
        f1.setVisible(true);
        f1.getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                f2.setVisible(true);
            }
        });
        f1.getBtnSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                f3.setVisible(true);
                f3.getTxtName1().setEnabled(false);
                f3.getTxtCredit1().setEnabled(false);

            }
        });
        f1.getBtnDisAll().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cs.sort((t, t1) -> {
                    if (Integer.parseInt(t.getCredit())<Integer.parseInt(t1.getCredit())) {
                        return -1;
                    }if (Integer.parseInt(t.getCredit())>Integer.parseInt(t1.getCredit())) {
                        return 1;
                    } else return 0; 
                });
                f4.getTxtAllCourses().setText("");
                for (course c : cs) {
                    String s = c.getCode() + "|" + c.getName() + "|" + c.getCredit() + "\n";
                    f4.getTxtAllCourses().append(s);
                }
                f4.setVisible(true);
            }
        });
        f1.getBtnExit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        f2.getBtnOkAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String code = f2.getTxtCode().getText().trim().toUpperCase();
                String name = f2.getTxtName().getText().trim();
                String cre = f2.getTxtCredit().getText().trim();
                name = name.replaceAll("\\s+", " ");
                StringBuilder sb = new StringBuilder(name);
                sb.replace(0, 1, String.valueOf(sb.charAt(0)).toUpperCase());
                for (int i = 0; i < sb.length() - 1; i++) {
                    if (sb.charAt(i) == ' ') {
                        sb.replace(i + 1, i + 2, String.valueOf(sb.charAt(i + 1)).toUpperCase());
                    }
                }
                name = sb.toString();
                course c = new course(code, name, cre);
                if (checkToAdd(cs, c)) {
                    cs.add(c);
                    JOptionPane.showMessageDialog(f1, "Done!", "Message", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(f1, "check again!", "Message", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        f2.getBtnClear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                f2.getTxtCode().setText("");
                f2.getTxtName().setText("");
                f2.getTxtCredit().setText("");
            }
        });
        f3.getBtnOkSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean flag = true;
                for (course c : cs) {
                    if (c.getCode().equalsIgnoreCase(f3.getTxtCode1().getText())) {
                        f3.getTxtName1().setText(c.getName());
                        f3.getTxtCredit1().setText(c.getCredit());
                        flag = !flag;
                    }
                }
                if (flag) {
                    f3.getTxtCredit1().setText("not found!");
                    f3.getTxtName1().setText("not found!");
                }
            }
        });

    }

    public static void main(String[] args) {
        ArrayList<course> cs = new ArrayList<>();
        Main m = new Main(new main(), new AddCourses(new main(), true),
                new Search(new main(), true),
                new Display(new main(), true));
        m.controller(cs);
    }
}
