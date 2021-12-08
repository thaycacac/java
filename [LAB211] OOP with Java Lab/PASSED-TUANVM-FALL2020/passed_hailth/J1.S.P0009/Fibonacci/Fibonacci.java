/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fibonacci;

/**
 *
 * @author hailiang194
 */
public class Fibonacci {

    private final int num;
    public static final int NOT_COMPUTED = -1;
    private final int[] fibonaccies;

    public Fibonacci(int num) {
        this.num = num;

        this.fibonaccies = new int[this.num];

        if (this.num > 0) {
            this.fibonaccies[0] = 0;
        }

        if (this.num > 1) {
            this.fibonaccies[1] = 1;
        }

        for (int i = 2; i < this.num; ++i) {
            this.fibonaccies[i] = NOT_COMPUTED;
        }
    }

    public int getNum() {
        return num;
    }

    public int[] getFibonaccies() {
        return fibonaccies;
    }

    private int compute(int index) {
        if (this.fibonaccies[index] != NOT_COMPUTED) {
            return this.fibonaccies[index];
        }

        this.fibonaccies[index] = this.compute(index - 1) + this.compute(index - 2);
        return this.fibonaccies[index];
    }

    public void compute() {
        this.compute(this.num - 1);
    }

}
