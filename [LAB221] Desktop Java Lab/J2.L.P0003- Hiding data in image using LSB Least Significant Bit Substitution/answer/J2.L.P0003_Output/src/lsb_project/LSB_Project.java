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
public class LSB_Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LSB_Module lsb = new LSB_Module();
        BufferedImage image = lsb.inputImage("img.png");
        List<Integer> listSecMess = lsb.encryptBinarySecretMess("ecec");
        for (Integer listSecMes : listSecMess) {
            System.out.print(listSecMes);
        }
        System.out.println("");
        BufferedImage newImage = lsb.mergeSecretMessWithImage(image, listSecMess);
        lsb.outputImage(newImage, "D://Study/Chuyên ngành/Chuyên ngành 4/PRJ321/Project/LSB_Project", "stegoImg", "png");
        
        BufferedImage stegoImage = lsb.inputImage("stegoImg.png");
        String binaryMess = lsb.getBinarySecretMess(stegoImage, listSecMess.size());
        String decryptMess = lsb.getSecretMess(binaryMess);
        System.out.println(decryptMess);
    }
    
}
