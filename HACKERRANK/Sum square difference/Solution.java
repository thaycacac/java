
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            long sum1 = 0, sum2 = 0;
            for (int i = 1; i <= n; i++) {
                sum1 += i;
                sum2 += i * i;
            }
            System.out.println(sum1 * sum1 - sum2);
        }
    }
}
