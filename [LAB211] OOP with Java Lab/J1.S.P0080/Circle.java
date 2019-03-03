
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author THAYCACAC
 */
public class Circle extends TwoDimensionalShape {

    private double r;

    public Circle() {
    }

    public Circle(double r) {
        this.r = r;
    }

    @Override
    double getArea() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        double result = Double.parseDouble(formatter.format(r * r * Math.PI));
        return result;
    }
}
