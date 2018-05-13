
import java.util.*;

public class Solution {

    public static boolean checkPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        int i = 5;
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int count = 0;
            int i = 2;
            while (true) {
                if (checkPrime(i) == true) {
                    count++;
                }
                if (count == n) {
                    System.out.println(i);
                    break;
                }
                i++;
            }
        }
    }
}
