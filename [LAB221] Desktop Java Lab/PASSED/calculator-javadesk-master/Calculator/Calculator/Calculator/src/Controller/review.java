/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Ekulajday12
 */
public class review {

    private BigDecimal firstNum;
    private BigDecimal secondNum;
    private boolean process;
    private boolean isMR = false;
    private boolean reset;
    BigDecimal memory = new BigDecimal("0");
    private int operator = -1;
    private final JTextField text;

    public review(JTextField text) {
        this.text = text;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public void pressNum(JButton btn) {
        String value = btn.getText();
        if (process || reset) {
            text.setText("0");
            process = false;
            reset = false;
        }
        isMR = false;
        BigDecimal temp = new BigDecimal(text.getText() + value);
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

    public JTextField pressMR() {
        text.setText(memory + "");
        isMR = true;
        return text;
    }

    public void pressClear() {
        firstNum = new BigDecimal("0");
        secondNum = new BigDecimal("0");
        text.setText("0");
        operator = -1;
    }

    public void caculate() {
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
            text.setText("ERROR");
            reset = true;
        }
    }

    public void pressResult() {
        if (!text.getText().equals("ERROR")) {
            caculate();
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
                process = false;
            } else {
                text.setText("ERROR");
            }
            reset = true;
        } catch (Exception e) {
            text.setText("ERROR");
        }
    }
    
    public void pressPercent(){
        try {
            pressResult();
            BigDecimal result = getValue();
            text.setText(result.doubleValue()/100 +""); 
            process = false;
        } catch (Exception e) {
            text.setText("ERROR");
        }
        reset = true;
    }
    public void pressInvert(){
        try {
            pressResult();
            BigDecimal result = getValue();
            if(result.doubleValue() !=0){
                text.setText(1/result.doubleValue() +"");
                process = false;
            } else{
                text.setText("ERROR");
            }
        } catch (Exception e) {
            text.setText("ERROR");
        }
        reset = true;
    }
}
