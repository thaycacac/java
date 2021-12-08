/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.formatter;

/**
 *
 * @author hailiang194
 * @param <E> datatype of element needs formatting
 */
public interface IFormatable<E> {
    /**
     * get the formatter from element to its format
     * @param e element
     * @return formatted value
     */
    public String formatTo(E e);
    
    /**
     * get the element from formatted element
     * @param e formatted element
     * @return element corresponding to this format
     * @throws java.lang.Exception when formatter exception occur
     */
    public E formatFrom(String e) throws Exception;
}
