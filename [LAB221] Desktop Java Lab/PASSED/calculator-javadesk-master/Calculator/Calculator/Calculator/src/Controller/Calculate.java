package Controller;

import GUI.Main;
import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HoaPC
 */
public class Calculate {

    private BigDecimal firstNum;
    private BigDecimal secondNum;
    private final JTextField text;
    private boolean reset;
    private boolean isMR = false;
    private boolean process;
    private int operator = -1;
    private BigDecimal memory = new BigDecimal("0");

    public Calculate(JTextField text) {
        this.text = text;
        operator = -1; // ?
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public void pressNumber(JButton btn) {
        BigDecimal temp;
        String value = btn.getText();
        if (process || reset) {
            text.setText("0"); // ?
            process = false;
            reset = false;
        }
        isMR = false;
        temp = new BigDecimal(text.getText() + value);
        text.setText(temp + "");
    }
    
    public void pressDot() {
        if (process || reset) {
            text.setText("0");
            process = false;
            reset = false;
        }
        if (!text.getText().contains(".")) {
            text.setText(text.getText() + ".");
        }
    }

    public BigDecimal getValue() {
        if (isMR) {
            return memory;
        }
        String value = text.getText();
        BigDecimal temp = new BigDecimal(value);
        return temp;

    }

    public void pressMR() {
        text.setText(memory + "");
        isMR = true;
    }

//    public boolean isMemory() {
//        return pressMR() != null; 
//    }
    //????
//    public BigDecimal changeValue() {
//        if (operator == 1 || operator == 2) {
//            return new BigDecimal("0");
//        } else {
//            return new BigDecimal("1");
//        }
//    }
    public void pressClear() {
        firstNum = new BigDecimal("0");
        secondNum = new BigDecimal("0");
        //memory = new BigDecimal("0");
        operator = -1;
    }

    public void calculate() {
        try {
            if (!process) {
                if (operator == -1) {
                    firstNum = getValue();
                } else {
                    secondNum = getValue();
                    switch (operator) {
                        case 1:
                            firstNum = firstNum.add(secondNum);
                            break;
                        case 2:
                            firstNum = firstNum.subtract(secondNum);
                            break;
                        case 3:
                            firstNum = firstNum.multiply(secondNum);
                            break;
                        case 4:
                            firstNum = firstNum.divide(secondNum);
                            break;
                    }
                }
                text.setText(firstNum + "");
                process = true;
            }
        } catch (Exception e) {
            reset = true;
            text.setText("ERROR");
        }

    }

    public void pressResult() {
        if (!text.getText().equals("ERROR")) {
            calculate();
            operator = -1;
        } else {
            text.setText(firstNum + "");
        }
    }

    public void pressNegate() {
        try {
            pressResult();
            text.setText(getValue().negate() + "");
            process = false;
        } catch (Exception e) {
            text.setText("ERROR");
        }
        reset = true;
    }

    public void pressSqrt() {
        try {
            pressResult();
            BigDecimal result = getValue();
            if (result.doubleValue() >= 0) {
                String display = Math.sqrt(result.doubleValue()) + "";
                if (display.endsWith(".0")) {
                    display = display.replace(".0", "");
                }
                text.setText(display);
                process = false;
            } else {
                text.setText("ERROR");
            }
        } catch (Exception e) {
            text.setText("ERROR");
        }
        reset = true;
    }
    public void pressPercent() {
        try {
            pressResult();
            text.setText((getValue().doubleValue()) / 100 + "");
            process = false;
        } catch (Exception e) {
            text.setText("ERROR");
        }
        reset = true;
    }

    public void pressInvert() {
        try {
            pressResult();
            double result = getValue().doubleValue();
            if (result != 0) {
                text.setText((1 / result) + "");
                process = false;
            } else {
                text.setText("ERROR");
            }
        } catch (Exception e) {
            text.setText("ERROR");
        }
        reset = true;
    }

    //MC : xóa bỏ trong bộ nhớ xét memory =0
    //MR: lấy ra giá trị trong bộ nhớ 
    //ấn số: => M+ : lưu giá trị đó vào memory
    //ấn số: => M- : lưu giá trị đối của nó vào memory
    //Nhấn M+ / M- => MR đổi màu
    //Nhấn MC: => MR về màu cũ
    public void pressMC() {
        memory = new BigDecimal("0");
    }
    
    public void pressMAdd() {
        try {
            memory = memory.add(getValue());
            process = false;
        } catch (Exception e) {
            text.setText("ERROR");
        }
        reset = true;
    }

    public void pressMSub() {
        try {
            memory = memory.add(getValue().negate());
            process = false;
        } catch (Exception e) {
            text.setText("ERROR");
        }
        reset = true;
    }
}
