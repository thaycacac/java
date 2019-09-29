/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.lab221.P0011.OB;

import javax.swing.*;

/**
 *
 * @author lab003
 */
public class Calculator {

    private int operator = -1;
    private double firstNum = 0;
    private double secondNum = 0;
    private boolean calcu = false;
    private boolean calcuM = false;
    private JTextField jtf = new JTextField();
    private JButton jb1;
    private JButton jb2;
    private JButton jb3;
    private JButton jb4;
    private JButton jb5;
    private JButton jb6;
    private JButton jb7;
    private JButton jb8;
    private JButton jb9;
    private JButton jb0;
    private JButton jbPlus;
    private JButton jbMini;
    private JButton jbMul;
    private JButton jbDiv;
    private JButton jbEqual;

    public void result() {
        float convertNumber = Float.parseFloat("" + firstNum);
        jtf.setText(convertNumber + "");
    }

    public void cal() throws Exception {
        if (!calcu) {
            if (operator == -1) {
                firstNum = getValue();
            } else {
                secondNum = getValue();
                if (operator == 1) {
                    firstNum += secondNum;
                    result();
                }
                if (operator == 2) {
                    firstNum -= secondNum;
                    result();
                }
                if (operator == 3) {
                    firstNum *= secondNum;
                    result();
                }
                if (operator == 4) {
                    if (secondNum == 0) {
                        jtf.setText("Error");
                        jb0.setEnabled(false);
                        jb1.setEnabled(false);
                        jb2.setEnabled(false);
                        jb3.setEnabled(false);
                        jb4.setEnabled(false);
                        jb5.setEnabled(false);
                        jb6.setEnabled(false);
                        jb7.setEnabled(false);
                        jb8.setEnabled(false);
                        jb9.setEnabled(false);
                        jbPlus.setEnabled(false);
                        jbMini.setEnabled(false);
                        jbMul.setEnabled(false);
                        jbDiv.setEnabled(false);
                        jbEqual.setEnabled(false);
                    } else {
                        firstNum /= secondNum;
                        result();
                    }
                }
            }
            calcu = true;
        }
    }

    public float getValue() {
        String value = jtf.getText();
        if (value.endsWith(".")) {
            value = value.replace(".", "");
        }
        return Float.parseFloat(value);
    }

    public void pressNumber(String value) {
        if (calcu || calcuM) {
            jtf.setText("0");
            calcu = false;
            calcuM = false;
        }
        if (jtf.getText().equals("0")) {
            jtf.setText(value);
        } else {
            jtf.setText(jtf.getText() + value);
        }
    }
}
