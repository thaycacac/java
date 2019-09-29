/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Decrypt;

import LSB_GUI.LSB_Decrypt_GUI;


/**
 *
 * @author MTC
 */
public class LSB_Main_Decrypt {
    public static void main(String[] args) {
        DecryptController control = new DecryptController();
        LSB_Decrypt_GUI deGUI = new LSB_Decrypt_GUI();
        
        control.addActionEncryptGUI(deGUI);
        deGUI.setVisible(true);
    }
}
