/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Decrypt;

import Controller.LSB_Model;
import LSB_GUI.LSB_Decrypt_GUI;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 *
 * @author MTC
 */
public class DecryptController extends LSB_Model implements IDecryptController{

    @Override
    public void addActionEncryptGUI(LSB_Decrypt_GUI deGUI) {
        deGUI.getBtnBrowse().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choosePath(deGUI);
            }
        });
        deGUI.getBtnShowHidMess().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = decryptMess(deGUI.getTxtPath().getText());
                deGUI.getTxtSecretMess().setText(s);
            }
        });
        deGUI.getTxtPath().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                BufferedImage image = inputImage(deGUI.getTxtPath().getText());
                if (image != null){
                    ImageIcon iconImg = new ImageIcon(image);
                    showImgOnLabel(iconImg, deGUI.getLblDisplaySetego());
                }
            }
        });
    }

    @Override
    public void choosePath(LSB_Decrypt_GUI deGUI) {
        
    }

    @Override
    public String decryptMess(String path) {
        BufferedImage stegoImage = inputImage(path);
        String siz = getBinarySecretMess(stegoImage, 32, 0, 0);
        int size = Integer.parseInt(siz, 2);
        String binaryMess = getBinarySecretMess(stegoImage, size*8, 0, 1);
        String decryptMess = getSecretMess(binaryMess);
        return decryptMess;
    }

    @Override
    public void showImgOnLabel (ImageIcon image, JLabel lbl) {
        image = smoodSizeImage(image, lbl);
        lbl.setIcon(image);
    }

    @Override
    public ImageIcon smoodSizeImage(ImageIcon image, JLabel lbl) {
        int width = lbl.getWidth();
        int height = lbl.getHeight();
        Image resizeIcon = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        image.setImage(resizeIcon);
        return image;
    }
    
    
}
