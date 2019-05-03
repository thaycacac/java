package Controller;

import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Sharp Team
 */
public class Calculate {

    private BigDecimal firstNumber;
    private BigDecimal secondNumber;
    private final JTextField text;
    private boolean reset;
    private boolean isMR = false;
    private boolean process;
    private int operator = -1;
    private BigDecimal memory = new BigDecimal("0");

    public Calculate(JTextField text) {
        this.text = text;
        operator = -1;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public void pressNumber(JButton btn) {
        BigDecimal temp;
        String value = btn.getText();
        if (process || reset) {
            text.setText("0");
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

    public void pressClear() {
        firstNumber = new BigDecimal("0");
        secondNumber = new BigDecimal("0");
        //memory = new BigDecimal("0");
        operator = -1;
    }

    public BigDecimal getValue() {
        if (isMR) {
            return memory;
        }
        String value = text.getText();

        BigDecimal temp;
        try {
            temp = new BigDecimal(value);
        } catch (Exception e) {
            return firstNumber;
        }
        return temp;
    }

    public void calculate() {
        if (!process) {
            if (operator == -1) {
                firstNumber = getValue();
            } else {
                secondNumber = getValue();
                switch (operator) {
                    case 1:
                        // to add value
                        firstNumber = firstNumber.add(secondNumber);
                        break;
                    case 2:
                        // to sub value
                        firstNumber = firstNumber.subtract(secondNumber);
                        break;
                    case 3:
                        // to multi value
                        firstNumber = firstNumber.multiply(secondNumber);
                        break;
                    case 4:
                        // to divide value
                        if (secondNumber.toString().equals("0")) {
                            text.setText("ERROR");
                            process = false;
                            return;
                        } else {
                            firstNumber = firstNumber.divide(secondNumber);
                            break;
                        }
                }
            }
            text.setText(firstNumber + "");
            process = true;
        }

    }

    public void pressResult() {
        if (!text.getText().equals("ERROR")) {
            calculate();
            operator = -1;
        } else {
            text.setText(firstNumber + "");
        }
    }

    public void pressNegate() {
        pressResult();
        text.setText(getValue().negate() + "");
        process = false;
        reset = true;
    }

    public void pressSqrt() {
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
        reset = true;
    }

    public void pressPercent() {
        pressResult();
        text.setText((getValue().doubleValue()) / 100 + "");
        process = false;
        reset = true;
    }

    public void pressInvert() {
        pressResult();
        double result = getValue().doubleValue();
        if (result != 0) {
            text.setText((1 / result) + "");
            process = false;
        } else {
            text.setText("ERROR");
        }
        reset = true;
    }

    public JTextField pressMR() {
        text.setText(memory + "");
        isMR = true;
        return text;
    }

    //MC : xóa bỏ trong bộ nhớ xét memory =0
    public void pressMC() {
        memory = new BigDecimal("0");
    }

    //ấn số: => M+ : lưu giá trị đó vào memory
    public void pressMAdd() {
        memory = memory.add(getValue());
        process = false;
        text.setText("ERROR");
    }

    //ấn số: => M- : lưu giá trị đối của nó vào memory
    public void pressMSub() {
        memory = memory.add(getValue().negate());
        process = false;
        reset = true;
    }
}
