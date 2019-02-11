package Test;

import Source.MathUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Thaycacac
 */
public class MathUtilsTest {
    @Test
    public void testMultiply() {
        double a = 5.0;
        double b = -4.0;
        
        double expected = -20.0;
        double result = MathUtils.multiply(a, b);
                
        assertEquals(expected, result, 0.00001);
    }
}
