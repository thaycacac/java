/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class CheckTest {

    Check check = new Check();

    public CheckTest() {
    }

    @Test
    public void testCoeff() {
        String str = null;
        String regex = null;
        check.coeff(str, regex);
    }

    @Test
    public void testQuadParseA() {
        String arg = null;
        check.quadParseA(arg);
    }

    @Test
    public void testQuadParseB() {
        String arg = null;
        check.quadParseB(arg);
    }

    @Test
    public void testQuadParseC() {
        String arg = null;
        check.quadParseC(arg);
    }

}
