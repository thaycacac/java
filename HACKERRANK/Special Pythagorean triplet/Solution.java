
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int result = -1;

            for (int a = 1; a <= n / 3; a++) {
                int c = (a * a / (2 * n - 2 * a)) + n / 2 - a / 2;
                int b = n - a - c;

                if (a * a + b * b == c * c && a < b && b < c) {
                    result = a * b * c;
                }
            }
            System.out.println(result);
        }
    }
}
