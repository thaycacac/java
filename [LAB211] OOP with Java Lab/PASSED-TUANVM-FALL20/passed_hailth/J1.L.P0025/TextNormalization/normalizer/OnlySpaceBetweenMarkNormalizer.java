/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextNormalization.normalizer;

import TextNormalization.INormalizable;
import java.util.StringTokenizer;

/**
 * only space after mark such as ',', '.', ':', etc
 *
 * @author hailiang194
 */
public class OnlySpaceBetweenMarkNormalizer implements INormalizable {

    private String mark;

    public OnlySpaceBetweenMarkNormalizer(String mark) {
        this.mark = mark;
    }

    @Override
    public String normalize(String source) {
        String normalized = new String();

        StringTokenizer tokenizer = new StringTokenizer(source, this.mark);

        while (tokenizer.hasMoreTokens()) {
            normalized += (tokenizer.nextToken().trim() + " " + this.mark + " ");
        }

        return normalized.substring(0, normalized.length() - 2); //remove this.mark + ' ' at the end of line
    }

}
