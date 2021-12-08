/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Fibonacci.Fibonacci;

/**
 *
 * @author hailiang194
 */
public class Main {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci(45);
        fibonacci.compute();

        for (int fibonaccy : fibonacci.getFibonaccies()) {
            System.out.print(fibonaccy + " ");
        }

        System.out.println();
    }
}
