/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextNormalization.normalizer;

import TextNormalization.INormalizable;
import java.util.StringTokenizer;

/**
 * Only space between words 
 * @author hailiang194
 */
public class OnlySpaceBetweenWordsNormalizer implements INormalizable {

    @Override
    public String normalize(String source) {
        String normalized = new String();
        StringTokenizer tokenizer = new StringTokenizer(source, " \t");

        while (tokenizer.hasMoreTokens()) {
            normalized += tokenizer.nextToken() + ' ';
        }
        
        return normalized.substring(0, normalized.length() - 1); //remove the last space
    }

}
