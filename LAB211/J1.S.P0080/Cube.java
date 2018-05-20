
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author THAYCACAC
 */
public class Cube extends ThreeDimensionalShape {

    private double a;

    public Cube() {
    }

    public Cube(double a) {
        this.a = a;
    }

    @Override
    double getArea() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        double result = Double.parseDouble(formatter.format(6 * a * a));
        return result;
    }

    @Override
    double getVolume() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        double result = Double.parseDouble(formatter.format(a * a * a));
        return result;
    }
}
