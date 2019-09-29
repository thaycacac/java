/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Decrypt;

import LSB_GUI.LSB_Decrypt_GUI;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author MTC
 */
public interface IDecryptController {
    public void addActionEncryptGUI(LSB_Decrypt_GUI deGUI);
    
    public void choosePath(LSB_Decrypt_GUI deGUI);
    public String decryptMess(String path);
    
    public void showImgOnLabel(ImageIcon image, JLabel lbl);
    public ImageIcon smoodSizeImage(ImageIcon image, JLabel lbl);
}
