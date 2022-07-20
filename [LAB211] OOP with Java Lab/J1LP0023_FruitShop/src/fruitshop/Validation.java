/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitshop;

import java.util.Scanner;

/**
 *
 * @author LeSyThanhLong
 */
public class Validation {
    

   
   private Scanner sc = new Scanner(System.in);
    
    public int inputInt(String mess, int min, int max) {
        System.out.print(mess);
        while(true) {
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                //check range of number
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + ": ");
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.out.print("Please input an integer number: ");
            }
        }
    }
    
    public double inputDouble(String mess, double min, double max) {
        System.out.print(mess);
        while(true) {
            String input = sc.nextLine();
            try {
                double number = Double.parseDouble(input);
                //check range of number
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + ": ");
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.out.print("Please input an double number: ");
            }
        }
    }
    
    public String inputString(String mess,String regex) {
        System.out.print(mess);
        while(true) {
            String input = sc.nextLine();
            if (!input.matches(regex)) {
                System.out.print("Please input match regex("+regex+").");
                continue;
            }
            return input;
        }
    }
    

    
    public boolean checkInputYN(String mess) {
        System.out.println(mess);
        while (true) {
             String result = sc.nextLine();
         
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
           
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }    


}
