/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

/**
 *
 * @author hailiang194
 */
public class InputValidation {

    public static boolean isValidCode(String code) {
        for (int i = 0; i < code.length(); ++i) {
            if(!Character.isAlphabetic(code.charAt(i)) && !Character.isDigit(code.charAt(i)))
                return false;
        }
        
        return true;
    }
}
