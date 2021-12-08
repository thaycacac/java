/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.fileIO;

/**
 *
 * @author hailiang194
 * @param <E> container type
 */
public interface IFileSavable<E> {
    /**
     * append data of element to file
     * @param container container store appended data 
     */
    public void append(E container) throws Exception;
}
