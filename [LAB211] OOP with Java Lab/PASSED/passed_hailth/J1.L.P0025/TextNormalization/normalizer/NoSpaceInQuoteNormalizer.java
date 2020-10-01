/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextNormalization.normalizer;

import TextNormalization.INormalizable;

/**
 * No spaces before and after sentence or word in quote
 *
 * @author hailiang194
 */
public class NoSpaceInQuoteNormalizer implements INormalizable {

    private final char QUOTE_MARK = '\"';

    @Override
    public String normalize(String source) {
        String normalized = new String();

        String line = new String(source);

        while (true) {
            int headQuoteIndex = line.indexOf(this.QUOTE_MARK);

            if (headQuoteIndex == -1) //not found
            {
                normalized += (line);
                return normalized;
            }

            normalized += line.substring(0, headQuoteIndex + 1);

            line = line.substring(headQuoteIndex + 1);
            int tailQuoteIndex = line.indexOf(this.QUOTE_MARK);
            tailQuoteIndex = (tailQuoteIndex != -1) ? tailQuoteIndex : line.length();

            normalized += (line.substring(0, tailQuoteIndex).trim() + this.QUOTE_MARK);

            line = line.substring(tailQuoteIndex);

            if (line.isEmpty()) {
                break;
            }
            
            line = line.substring(1); //remove the QUOTE of tail

        }

        return normalized; //remove the QUOTE_MARK at the end
    }

}
