package fibonacci;

/**
 *
 * @author THAYCACAC
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("The 45 sequence fibonacci");
        System.out.println(fib(45));
    }

    public static int fib(int n) {
        return fibonnaciHelper(n, 1, 0);
    }
    public static int fibonnaciHelper(int term, int lower, int higher) {
        if (term < 2) {
            return higher;
        }
        System.out.print(higher + " ");
        return fibonnaciHelper(term - 1, higher, higher + lower);
    }
}
