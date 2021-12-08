/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextNormalization.normalizer;

import TextNormalization.INormalizable;

/**
 *
 * @author hailiang194
 */
public class DotAtTheEndNormalizer implements INormalizable{

    @Override
    public String normalize(String source) {
        char lastChar = source.charAt(source.length() - 1);
        
        if(lastChar == '.')
            return source;
        
        return source + ".";
    }
    
}
