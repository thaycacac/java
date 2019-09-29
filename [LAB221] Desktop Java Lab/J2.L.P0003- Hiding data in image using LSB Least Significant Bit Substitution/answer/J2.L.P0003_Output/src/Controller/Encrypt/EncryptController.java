/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Encrypt;

import Controller.LSB_Model;
import LSB_GUI.LSB_Encrypt_GUI;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 *
 * @author MTC
 */
public class EncryptController extends LSB_Model implements IEncryptController{

    BufferedImage hidedImg;

    public EncryptController(BufferedImage hidedImg) {
        this.hidedImg = hidedImg;
    }
    
    @Override
    public void addActionEncryptGUI(LSB_Encrypt_GUI enGUI) {
        enGUI.getBtnBrowse().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choosePath(enGUI);
            }
        });
        enGUI.getBtnHideMess().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hidedImg = hideMessage(enGUI, hidedImg);
                ImageIcon iconImg = new ImageIcon(hidedImg);
                showImgOnLabel(iconImg, enGUI.getLblDisplaySetego());
            }
        });
        enGUI.getTxtPath().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                BufferedImage image = inputImage(enGUI.getTxtPath().getText());
                if (image != null){
                    ImageIcon iconImg = new ImageIcon(image);
                    showImgOnLabel(iconImg, enGUI.getLblDisplayOri());
                }
            }
        });
        enGUI.getBtnSaveSetego().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(enGUI, "Enter name Setego", "Fill name:", 1);
                outputImage(hidedImg, "", name, "png");
            }
        });
    }

    @Override
    public void choosePath(LSB_Encrypt_GUI enGUI) {
        
    }

    @Override
    public BufferedImage hideMessage(LSB_Encrypt_GUI enGUI, BufferedImage hidedImg) {
        String secretMess = enGUI.getTxtSecretMess().getText();
        String path = enGUI.getTxtPath().getText();
        List<Integer> listBinSecMess = encryptBinarySecretMess(secretMess);
        BufferedImage image = inputImage(path);
        hidedImg = hideNumber(image, secretMess.length());
        hidedImg = mergeSecretMessWithImage(hidedImg, listBinSecMess, 0, 1);
        return hidedImg;
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
