/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Form.MainForm;

/**
 *
 * @author hailiang194
 */
public class Main {
    public static void main(String[] args) {
        MainForm form = new MainForm();
        form.setup();
        form.loop();
    }
}
