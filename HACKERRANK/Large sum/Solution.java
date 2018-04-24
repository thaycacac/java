
import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.next());
        BigInteger sum = new BigInteger(in.next());
        for (int i = 0; i < n-1; i++) {
            BigInteger numAdd = new BigInteger(in.next());
            sum = sum.add(numAdd);
        }
        String result = sum.toString();
        
        System.out.println(result.substring(0, 10));
    }
}
