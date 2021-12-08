/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

/**
 *
 * @author hailiang194
 */
public abstract class Form {
    protected enum EXIT_STATUS{UPDATE_EXIT, LOOP_EXIT};
    
    /**
     * run it only after initializing object
     */
    public abstract void setup();
    
    /**
     * each loop in loop
     * @return exit status of itself
     */
    protected abstract EXIT_STATUS update();
    
    /**
     * display form
     */
    public void loop()
    {
        while(update() != EXIT_STATUS.LOOP_EXIT);
    }
}
