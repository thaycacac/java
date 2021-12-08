/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.manager;

import java.util.ArrayList;

/**
 *
 * @author hailiang194
 * @param <E> finding element type
 */
public interface IFind<E> {
    /**
     * find the first element that is identified
     * @param identify identify
     * @return element
     */
    public E findFirst(IIdentify<E> identify);
    
    /**
     * find all element that is identified
     * @param indetify identify
     * @return list of element
     */
    public ArrayList<E> findAll(IIdentify<E> indetify);
}
