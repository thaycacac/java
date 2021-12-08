/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextNormalization;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Text normalizer
 * This has normalize "There are no blank lines between line"
 * @author hailiang194
 */
public class TextNormalizer {

    private ArrayList<INormalizable> normalizers;

    public TextNormalizer() {
        this.normalizers = new ArrayList<>();
    }

    /**
     * append new normalizer
     * @param normalizer 
     */
    public void addNormalizer(INormalizable normalizer) {
        this.normalizers.add(normalizer);
    }

    /**
     * normalize the source string and remove empty lines
     * @param source source string
     * @return normalized string
     */
    public String normalize(String source) {
        StringTokenizer token = new StringTokenizer(source, "\n");
        String normalized = new String();
        
        while(token.hasMoreTokens())
        {
            String line = token.nextToken().trim();
            if(line.isEmpty())
                continue;
            
            for (INormalizable normalizer : this.normalizers) {
                line = normalizer.normalize(line);
            }
            
            normalized += (line + '\n');
        }
        
        return normalized.substring(0, normalized.length() - 1); //remove \n at the end
    }
}
