/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class LSB_Model {

    public BufferedImage inputImage(String path) {
        BufferedImage bImage = null;
        try {
            bImage = ImageIO.read(new File(path));
        } catch (IOException ex) {
            System.out.println("Not found image with " + path);
        }
        return bImage;
    }

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

    public int getRGBatPixel(int posX, int posY, BufferedImage img) {
        return img.getRGB(posX, posY);
    }

    public BufferedImage hideNumber(BufferedImage oriImage, int number) {
        List<Integer> binNum = new ArrayList<>();
        String s = Integer.toBinaryString(number);
        for (int i = 0; i < 32 - s.length(); i++) {
            binNum.add(0);
        }
        for (int i = 0; i < s.length(); i++) {
            binNum.add(Integer.parseInt(s.charAt(i)+""));
        }
        return mergeSecretMessWithImage(oriImage, binNum, 0, 0);
    }

    public BufferedImage mergeSecretMessWithImage(BufferedImage oriImage, List<Integer> binMess, int posX, int posY) {
        BufferedImage newImage = oriImage;
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
            posX = posX >= oriImage.getWidth() ? 0 : posX+1;
            posY = posX >= oriImage.getWidth() ? posY+1 : posY;
        } while (i < binMess.size());
        return newImage;
    }

    public void outputImage(BufferedImage img, String path, String name, String type) {
        try {
            String s = name + "." + type;
            if (!path.isEmpty()) {
                s = path + "/" + name + "." + type;
            }
            ImageIO.write(img, type, new File(s));
        } catch (IOException ex) {
            System.out.println("Save file error");
        }

    }

    public String getBinarySecretMess(BufferedImage stegoImg, int size, int posX, int posY) {
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
            posX = posX >= stegoImg.getWidth() ? 0 : posX+1;
            posY = posX >= stegoImg.getWidth() ? posY+1 : posY;
        } while (i < size);
        return binary;
    }

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
