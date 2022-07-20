/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managecandidate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author LeSyThanhLong
 */
public class Validation {
   

    private final static Scanner sc = new Scanner(System.in);
    private static final String PHONE_VALID = "(0[3|5|7|8|9])+([0-9]{8})";

    private static final String EMAIL_VALID
            = "[A-Za-z]\\w+@\\w+(\\.\\w+){1,3}$";

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
            if(!input.matches(regex)){
                System.out.println("Please input matches regex:"+regex);
                continue;
            }
            if (input.equals("")) {
                System.out.print("Please input a non-empty string: ");
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

    //check user input y/Y or n/N
    public boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = sc.nextLine();
            //check user input y/Y or n/N
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    //check user input graduation rank
    public String checkInputGraduationRank() {
        while (true) {
            String result = sc.nextLine();
            if (result.equalsIgnoreCase("Excellence")
                    || result.equalsIgnoreCase("Good")
                    || result.equalsIgnoreCase("Fair")
                    || result.equalsIgnoreCase("Poor")) {
                return result;
            } else {
                System.err.println("Please input string: Excellence, Good, Fair, Poor");
                System.out.print("Enter again: ");
            }
        }
    }

    //check id exist or not
    public boolean checkIdExist(ArrayList<Candidate> candidates, String id) {
        for (Candidate candidate : candidates) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                System.err.println("Id exist.");
                return false;
            }
        }
        return true;
    }



}
