/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import GUI.Calculator;
import static java.lang.Math.sqrt;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JFrame;

/**
 *
 * @author dungvqse04406
 */
//ktra r thực thi
//khi ko thỏa mãn điều kiện thì đảm bảo sẽ ko thực thi
//sau dấu = , luôn xét KQ về = 0 (khi thầy check số)
//phép chia ko chia được cho 0 , khai căn cho số âm , lấy giá trị phép tính ko tính đc , chuyển ra KQ . 
//Error hiện thông báo , lấy số nhập trước để làm phép tính tiếp 

public class CalculatorController {

    Calculator c;
    BigDecimal result = new BigDecimal("0");
    BigDecimal Dnum = new BigDecimal("0");
    String operator = ""; //khai thác
    Boolean newNumber = true;

    public CalculatorController(Calculator c) {
        this.c = c;
    }

    //button All Clear
    //Reset everything to start
    //return "0" to txtDisplay
    
//    nút Xóa tất cả
//    Đặt lại mọi thứ để bắt đầu
//    trả về "0" cho txtDisplay
        
    public String ButtonClear() {
        Dnum = new BigDecimal("0");
        result = new BigDecimal("0");
        operator = "";
        newNumber = true;
        return ("0");
    }

    //button MC
    //Clear Memory
    
//    nút MC
//    Dọn dẹp bộ nhớ
    public void ButtonMC() {
        Dnum = new BigDecimal("0");
        newNumber = true;
    }

    //button MR
    //Return number from memory
    
    // nút MR
    //Trả về số về bộ nhớ
    public String ButtonMR() {
        result = Dnum;
        newNumber = true;
        return (FixNumber(Dnum));
    }

    //button M+
    //Add current number to memory
    //text is what current txtDisplay
    
    // nút M +
    //Thêm số hiện tại vào bộ nhớ
    //văn bản là hiển thị hiện tại
    public void ButtonMAdd(String text) {
        //Dnum can't add a number if there was an error   
        //Dnum không thể thêm số nếu có lỗi
        if (!text.equals("Error")) {
            Dnum = Dnum.add(new BigDecimal(text));
            newNumber = true;
        }
    }

    //button M-
    //Number in memory will substract current number
    //text is what current txtDisplay
    
//    nút M-
//    Số trong bộ nhớ sẽ trừ số hiện tại
//    văn bản là hiển thị hiện tại
    public void ButtonMSub(String text) {
        //Dnum can't sub a number if there was an error   
        //Không thể + số nếu có lỗi
        if (!text.equals("Error")) {
            Dnum = Dnum.subtract(new BigDecimal(text));
            newNumber = true;
        }
    }

    //button √ 
    //SQRT current number if possible. Display Error if not
    
    //nút √ 
    //Có thể khai căn số hiện tại , hiển thị lỗi hoặc là ko
    public String ButtonSQRT() {       
        //current number < 0 , can't be sqrt
        //số hiện tại <0, không thể khai căn
        if (result.compareTo(new BigDecimal("0")) == -1) {
            return "Error";
        } 
        //current number >= 0, it can be sqrt
        //số hiện tại> = 0, nó có thể khai căn
        else {
            Double dnum = sqrt(result.doubleValue());
            result = new BigDecimal(dnum);
            result = result.divide(new BigDecimal("1"), RoundingMode.HALF_EVEN);
            newNumber = true;
            return (FixNumber(result));         
        }
    }

    //button %
    //Divde current result by 100
    //return result to display in txtDisplay
    
    // nút%
    //Chia kết quả hiện tại cho 100
    //trả về kết quả để hiển thị trong txtDisplay
    public String ButtonPercent() {
        result = result.divide(new BigDecimal("100"));
        newNumber = true;
        return (FixNumber(result));
    }

    //button 1/X
    //Take 1 then divide it by current result. Return to display in txtDisplay
    
    // nút 1 / X
    //Lấy 1 rồi chia cho kết quả hiện tại. Quay lại hiển thị trong txtDisplay
    public String ButtonFlip() {
        //if result = 0 , 1 can't divide it
        //nếu kết quả = 0, 1 không thể chia nó
        if (result.equals(new BigDecimal("0"))) {
            return "Error";
        } //result != 0 , 1 can divide it
        else {
            BigDecimal One = new BigDecimal("1");
            result = One.divide(result, 12, RoundingMode.HALF_EVEN);
            newNumber = true;
            return (FixNumber(result));          
        }
    }

    //button .
    //Add dot if current number is an integer
    
    // nút.
    //Thêm dấu chấm nếu số hiện tại là số nguyên
    public String ButtonDot(String text) {
        //There was a input number
        //Có một số đầu vào
        if (!newNumber) {
            newNumber = false;
            //go through text to find dot
            //đi qua văn bản để tìm dấu chấm
            for (int i = 0; i < text.length(); i++) //there was a dot in number
                                                    //có một dấu chấm trong số
            {
                if (text.charAt(i) == '.') {
                    return text;
                }
            }
            //there wasn't any dot in number
            //không có bất kỳ dấu chấm nào trong số
            return text + '.';
        } 
            //current value of input number is 0
            //giá trị hiện tại của số đầu vào là 0
        else {
            newNumber = false;
            return "0.";
        }
    }

    //button swap +/-
    //Write opposite number of the current result
    
    // hoán đổi nút +/-
    //Viết số đối diện của kết quả hiện tại
    public String ButtonSwap() {
        result = new BigDecimal("0").subtract(result);
        newNumber = true;
        return (FixNumber(result));
    }

    public String addDigit(String text, String s) {
        //input digit will replace current text
        // chữ số đầu vào sẽ thay thế văn bản hiện tại
        if (newNumber) {
            //after operator = result will be reset so next operation won't take previous operation result
            //*sau toán tử = kết quả sẽ được đặt lại để thao tác tiếp theo không lấy kết quả hoạt động trước đó
            if (operator.equals("=")) {
                result = new BigDecimal("0");
            }
            newNumber = false;
            return (FixNumber(new BigDecimal(s)));
        } else 
        //current text is 0, the first input digit will replace it
        //văn bản hiện tại là 0, chữ số đầu tiên sẽ thay thế nó
         if ((text).equals("0")) {
                return (FixNumber(new BigDecimal("s")));
            } else 
        //add 1 digit to last of the text
        //thêm 1 chữ số vào cuối văn bản
            {
                return (text + s);
            }
    }

    //Calculate opression with input operator
    //text is current display of txtDisplay
    
    // Tính toán áp bức với toán tử đầu vào 
    // văn bản là hiển thị hiện tại của text Display
    public String Calculate(String text, String currentOp) {
        String output = text;
        //There was an input number
        //Có một số đầu vào
        if (!newNumber) {
            BigDecimal num = new BigDecimal(text);
            switch (operator) {
                case "+":
                    result = result.add(num);
                    break;
                case "-":
                    result = result.subtract(num);
                    break;
                case "x":
                    result = result.multiply(num);
                    break;
                case "/":
                    //can't divide by 0
                    //không thể chia cho 0
                    if (num.equals(new BigDecimal("0"))) {
                        output = "Error";
                    } else {
                        result = result.divide(num, 12, RoundingMode.HALF_EVEN);
                    }
                    break;
                default:
                    result = new BigDecimal(text);
                    break;
            }
            //If there was an error during opression, error will be displayed
            //Nếu có lỗi trong quá trình nén, lỗi sẽ được hiển thị
            if (!output.equals("Error")) {
                output = FixNumber(result);
            }
        }
        //save new operator to calculate next opression
        //lưu toán tử mới để tính áp bức tiếp theo
        operator = currentOp;
        newNumber = true;
        return output;
    }

    //return interger format if input number is integer
    //trả về định dạng số nguyên nếu số đầu vào là số nguyên
    public String FixNumber(BigDecimal currentNum) {
        String s = currentNum.toString();
        //go thought s to find if it has dot
        //đi qua s để tìm xem nó có dấu chấm không
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                String newS = "";
                int newL = s.length();
                //go through s to delete all last 0 digit after dot
                //đi qua s để xóa tất cả chữ số 0 cuối cùng sau dấu chấm
                for (int j = s.length() - 1; j > 1; j--) 
                //while last digit is still 0
                //trong khi chữ số cuối cùng vẫn là 0
                {
                    if (s.charAt(j) == '0') 
                //update new length of s
                //cập nhật độ dài mới của s
                    {
                        newL = j;
                    } 
                //next digit is real
                //chữ số tiếp theo là có thật
                    else {
                        break;
                    }
                }
                //all digit after dot is 0.so dot is useless
                //tất cả chữ số sau dấu chấm là 0 . vì vậy dấu chấm là vô ích
                if (s.charAt(newL - 1) == '.') {
                    newL--;
                }
                //go through s to save new string
                //đi qua s để lưu chuỗi mới
                for (int j = 0; j < newL; j++) {
                    newS = newS + s.charAt(j);
                }
                s = newS;
                break;
            }
        }
        return s;
    }

    public void frameSetting(JFrame frame) {
        frame.setLocationRelativeTo(null); //show center
    }

}
