
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author THAYCACAC
 */
public class Triangle extends TwoDimensionalShape {
    
    private double a;
    private double b;
    private double c;
    
    public Triangle() {
    }
    
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    double getArea() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        double p = (a + b + c) / 2;
        double result;
        if (a + b < 0 || a + c < 0 || b + c < 0) {
            result = 0;
        } else {
            result = Double.parseDouble(formatter.format(Math.sqrt(p * (p - a) * (p - b) * (p - c))));
        }
        return result;
    }
    
}
