/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lsb_project;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author MTC
 */
public class LSB_Module implements LSB_Interface {

    @Override
    public BufferedImage inputImage(String path) {
        BufferedImage bImage = null;
        try {
            bImage = ImageIO.read(new File(path));
        } catch (IOException ex) {
            System.out.println("Not found image with " + path);
        }
        return bImage;
    }

    @Override
    public List<Integer> encryptBinarySecretMess(String secretMess) {
        byte[] bytes = secretMess.getBytes();
        List<Integer> binary = new ArrayList<>();
        for (byte b : bytes) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                binary.add((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }
        return binary;
    }

    @Override
    public int getRGBatPixel(int posX, int posY, BufferedImage img) {
        return img.getRGB(posX, posY);
    }

    @Override
    public BufferedImage mergeSecretMessWithImage(BufferedImage oriImage, List<Integer> binMess) {
        BufferedImage newImage = oriImage;
        int posX = 0, posY = 0;
        int i = 0;
        do {
            int rgb = getRGBatPixel(posX, posY, newImage);
            //R
            if (i < binMess.size()) {
                if (binMess.get(i++) == 0) {
                    rgb = rgb & 0xFFFEFFFF;
                } else {
                    rgb = (rgb | 0x00010000);
                }
            }
            //G
            if (i < binMess.size()) {
                if (binMess.get(i++) == 0) {
                    rgb = rgb & 0xFFFFFEFF;
                } else {
                    rgb = (rgb | 0x00000100);
                }
            }
            //B
            if (i < binMess.size()) {
                if (binMess.get(i++) == 0) {
                    rgb = rgb & 0xFFFFFFFE;
                } else {
                    rgb = (rgb | 0x00000001);
                }
            }
            newImage.setRGB(posX, posY, rgb);
            posX++;
            posY++;
        } while (i < binMess.size());
        return newImage;
    }

    @Override
    public void outputImage(BufferedImage img, String path, String name, String type) {
        try {
            String s = path + "/" + name + "." + type;
            ImageIO.write(img, type, new File(s));
        } catch (IOException ex) {
            System.out.println("Save file error");
        }

    }

    @Override
    public String getBinarySecretMess(BufferedImage stegoImg, int size) {
        int posX = 0, posY = 0;
        int i = 0;
        String binary = "";
        do {
            int rgb = stegoImg.getRGB(posX, posY);
            Color c = new Color(rgb);
            int R = c.getRed();
            int G = c.getGreen();
            int B = c.getBlue();
            String rString = Integer.toBinaryString(R);
            String gString = Integer.toBinaryString(G);
            String bString = Integer.toBinaryString(B);
            if (i++ < size) {
                binary += rString.charAt(rString.length() - 1);
            }
            if (i++ < size) {
                binary += gString.charAt(gString.length() - 1);
            }
            if (i++ < size) {
                binary += bString.charAt(bString.length() - 1);
            }
            posX++;
            posY++;
        } while (i < size);
        return binary;
    }

    @Override
    public String getSecretMess(String binaryMess) {
        String s = "";
        for (int index = 0; index < binaryMess.length(); index += 8) {
            String temp = binaryMess.substring(index, index + 8);
            int num = Integer.parseInt(temp, 2);
            char letter = (char) num;
            s = s + letter;
        }
        return s;
    }

    @Override
    public String encryptBinSecretMess(String secretMess) {
        byte[] bytes = secretMess.getBytes();
        String binary = "";
        for (byte b : bytes) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                binary += ((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }
        return binary;
    }

}
