/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextNormalization.normalizer;

import TextNormalization.INormalizable;
import java.util.StringTokenizer;

/**
 * Uppercase the first character of the sentence, other 
 * @author hailiang194
 */
public class UppercaseFirstCharOfSentenceNormalizer implements INormalizable {

    @Override
    public String normalize(String source) {
        String normalized = new String();

        StringTokenizer tokenizer = new StringTokenizer(source, ".");

        while (tokenizer.hasMoreTokens()) {
            String sentence = tokenizer.nextToken().trim().toLowerCase();

            if(sentence.isEmpty())
                continue;
            
            normalized += (". " + Character.toUpperCase(sentence.charAt(0)) + sentence.substring(1));
        }

        return normalized.substring(2); //remove ". " at the first
    }

}
