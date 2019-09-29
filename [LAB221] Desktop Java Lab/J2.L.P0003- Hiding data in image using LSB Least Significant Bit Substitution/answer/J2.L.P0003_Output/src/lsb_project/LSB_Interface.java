/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lsb_project;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author MTC
 */
public interface LSB_Interface {
    
    public BufferedImage inputImage (String path);
    public void outputImage (BufferedImage img, String path, String name, String type);
    public List<Integer> encryptBinarySecretMess (String secretMess);
    public int getRGBatPixel (int posX, int posY, BufferedImage img);
    public BufferedImage mergeSecretMessWithImage (BufferedImage oriImage, List<Integer> binMess);
    
    public String getBinarySecretMess (BufferedImage stegoImg, int size);
    public String getSecretMess (String binaryMess);
    public String encryptBinSecretMess (String secretMess);
}
