/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managestudent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author LeSyThanhLong
 */
public class Validation {
      private final static Scanner in = new Scanner(System.in);

   
   private Scanner sc = new Scanner(System.in);
    
    //get input integer number between min and max
    public int inputInt(String mess, int min, int max) {
        System.out.print(mess);
        //force user input exectly integer number
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
    
    //get input double number between min and max
    public double inputDouble(String mess, double min, double max) {
        System.out.print(mess);
        //force user input exectly double number
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
    
    //get non-empty string
    public String inputString(String mess,String regex) {
        System.out.print(mess);
        //force user input exectly non-empty string
        while(true) {
            String input = sc.nextLine();
            if (!input.matches(regex)) {
                System.out.print("Please input match regex : ");
                continue;
            }
            return input;
        }
    }
    
    //get valid date
    public String inputDate(String mess) {
        System.out.print(mess);
        //set format of date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        //force user input exectly a date
        while(true) {
            String input = sc.nextLine();
            try {
                Date date = dateFormat.parse(input);
                //get current date
                Date curDate = Calendar.getInstance().getTime();
                //check range of date
                if (curDate.compareTo(date) < 0) {
                    System.out.print("Please input date that before current date: ");
                    continue;
                }
                dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                return dateFormat.format(date);
            } catch (Exception e) {
                System.out.print("Please input valid date (dd-MM-yyyy): ");
            }
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

    public boolean checkInputUD(String mess) {
        System.out.println(mess);
        while (true) {
           String result = sc.nextLine();
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }
    }

    
    public String checkInputCourse(String mess) {
        //loop until user input correct
        while (true) {
           String result = sc.nextLine();
            //check input course in java/ .net/ c/c++
            if (result.equalsIgnoreCase("java")
                    || result.equalsIgnoreCase(".net")
                    || result.equalsIgnoreCase("c/c++")) {
                return result;
            }
            System.err.println("There are only three courses: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }
    }

    //check student exist
    

}
