
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HackerRank2 {

    public static long fibonacci(long a1, long a2) {
        return a1 + a2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long a1 = 1, a2 = 2, sum = 0, atemp;
            long n = in.nextLong();
            while (true) {
                if (a2 > n) {
                    break;
                }
                if (a2 % 2 == 0) {
                    sum += a2;
                }
                atemp = a2;
                a2 = fibonacci(a1, a2);
                a1 = atemp;
            }
            System.out.println(sum);
        }
    }
}
