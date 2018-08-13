
import java.rmi.Naming;

/**
 *
 * @author THAYCACAC
 */
public class ClientCalculator {

    public static void main(String[] args) {
        try {
            Calculator cal = (Calculator) Naming.lookup("rmi://127.0.0.1:3000/Calculator");
            double a = 10;
            double b = 20;
            double result = cal.mul(a, b);
            System.out.println("Result: " + result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
