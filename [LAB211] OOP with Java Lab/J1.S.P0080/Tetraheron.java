
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author THAYCACAC
 */
public class Tetraheron extends ThreeDimensionalShape {

    private double r;

    public Tetraheron() {
    }

    public Tetraheron(double r) {
        this.r = r;
    }

    @Override
    double getArea() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        double result = Double.parseDouble(formatter.format(4 * r * r * Math.PI));
        return result;
    }

    @Override
    double getVolume() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        double result = Double.parseDouble(formatter.format(4 * r * r * r * Math.PI / 3));
        return result;
    }

}
