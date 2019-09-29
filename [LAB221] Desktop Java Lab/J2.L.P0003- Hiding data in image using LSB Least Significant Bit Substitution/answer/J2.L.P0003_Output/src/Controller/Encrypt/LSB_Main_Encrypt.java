/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Encrypt;

import LSB_GUI.LSB_Encrypt_GUI;
import java.awt.image.BufferedImage;

/**
 *
 * @author MTC
 */
public class LSB_Main_Encrypt {
    public static void main(String[] args) {
        BufferedImage hidedImg = new BufferedImage(10, 10, 1);
        EncryptController control = new EncryptController(hidedImg);
        LSB_Encrypt_GUI enGUI = new LSB_Encrypt_GUI();
        
        control.addActionEncryptGUI(enGUI);
        enGUI.setVisible(true);
    }
}
