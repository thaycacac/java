/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextNormalization;

/**
 *
 * @author hailiang194
 */
public interface INormalizable {
    /**
     * normalize source string
     * @param source source string
     * @return normalized string
     */
    public String normalize(String source);
}
