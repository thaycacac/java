
import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int k = in.nextInt();
            String num = in.next();
            int max = 0;
            for (int i = 0; i <= num.length() - k; i++) {
                int numCheck = 1;
                for (int j = i; j < i+k; j++) {
                    numCheck *= Integer.parseInt(Character.toString(num.charAt(j)));
                }
                if (numCheck > max) {
                        max = numCheck;
                    }
            }
            System.out.println(max);
        }
    }
}
