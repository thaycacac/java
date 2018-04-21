
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author THAYCACAC
 */
public class Square extends TwoDimensionalShape {

    private double a;

    public Square() {
    }

    public Square(double a) {
        this.a = a;
    }

    @Override
    double getArea() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        double result = Double.parseDouble(formatter.format(a * a));
        return result;
    }
}
