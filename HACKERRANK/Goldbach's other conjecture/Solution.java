
    import java.util.*;

    public class Solution {

        public static boolean checkPrime(int n) {
            if (n <= 1) {
                return false;
            } else if (n <= 3) {
                return true;
            } else if (n % 2 == 0 || n % 3 == 0) {
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

        public static boolean checkSquare(int n) {
            int numLastCheck = n % 10;
            if (numLastCheck == 2 || numLastCheck == 3
                    || numLastCheck == 7 || numLastCheck == 8) {
                return false;
            }
            int numCheck = (int) Math.sqrt(n);
            if (numCheck * numCheck == n) {
                return true;
            }
            return false;
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int t = Integer.parseInt(in.nextLine());
            for (int i = 0; i < t; i++) {
                int count = 0;
                int n = Integer.parseInt(in.nextLine());
                for (int j = 2; j <= n; j++) {
                    if (checkPrime(j) == true && ((n - j) % 2 == 0)
                            && checkSquare((n - j) / 2) == true) {
                        count++;
                    }
                    
                }
                System.out.println(count);
            }
        }
    }
