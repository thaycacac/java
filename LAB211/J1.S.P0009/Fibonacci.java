
/**
 *
 * @author THAYCACAC
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("The 45 sequence fibonacci");
        fibonnaciHelper(45, 1, 0);
    }

    public static int fibonnaciHelper(int term, int lower, int higher) {
        if (term < 2) {
            return higher;
        }
        System.out.print(higher + " ");
        return fibonnaciHelper(term - 1, higher, higher + lower);
    }

}
