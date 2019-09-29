/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Encrypt;

import LSB_GUI.LSB_Encrypt_GUI;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author MTC
 */
public interface IEncryptController {
    public void addActionEncryptGUI(LSB_Encrypt_GUI enGUI);
    
    public void choosePath(LSB_Encrypt_GUI enGUI);
    public BufferedImage hideMessage(LSB_Encrypt_GUI enGUI, BufferedImage hidedImg);
    
    public void showImgOnLabel(ImageIcon image, JLabel lbl);
    public ImageIcon smoodSizeImage(ImageIcon image, JLabel lbl);
}
