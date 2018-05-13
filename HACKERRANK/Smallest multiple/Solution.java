
import java.util.*;

public class Solution {

    public static boolean checkPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            long result = 1;
            for (int i = 1; i <= n; i++) {
                if (checkPrime(i) == true) {
                    int check = 1;
                    while (true) {
                        check *= i;
                        if (check * i > n) {
                            break;
                        }
                    }
                    result *= check;
                }
            }
            System.out.println(result);
        }

    }
}
