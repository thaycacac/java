/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.lab221.P0111.OB;

import java.math.BigDecimal;
import sun.nio.cs.ext.Big5;

/**
 *
 * @author lab003
 */
public class LogicCalculator {

    public double add(double firstNum, double secondNum) {
        return BigDecimal.valueOf(firstNum).add(BigDecimal.valueOf(secondNum)).doubleValue();
    }

    public double substract(double firstNum, double secondNum) {
        return BigDecimal.valueOf(firstNum).subtract(BigDecimal.valueOf(secondNum)).doubleValue();
    }

    public double multiply(double firstNum, double secondNum) {
        return BigDecimal.valueOf(firstNum).multiply(BigDecimal.valueOf(secondNum)).doubleValue();
    }

    public double divide(double firstNum, double secondNum) {
        return firstNum / secondNum;
    }

    public double square(double firstNum, double secondNum) {
        return firstNum * secondNum * secondNum;
    }

    public double sqrRoot(double secondNum) {
        return Math.sqrt(secondNum);
    }

    public double oneDivideByX(double secondNum) {
        return 1.0 / secondNum;
    }

    public double negateOfX(double secondNum) {
        return secondNum * (-1);
    }

    public double percent(double firstNum, double secondNum) {
        return firstNum * secondNum / 100;
    }
}
