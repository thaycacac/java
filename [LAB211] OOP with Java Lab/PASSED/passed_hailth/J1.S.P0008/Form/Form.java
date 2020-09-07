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

    protected enum EXIT_OPTION {
        UPDATE_EXIT, LOOP_EXIT
    };

    public abstract void setup();

    public abstract EXIT_OPTION update();

    public void loop() {
        while(this.update() != EXIT_OPTION.LOOP_EXIT);
    }

}
