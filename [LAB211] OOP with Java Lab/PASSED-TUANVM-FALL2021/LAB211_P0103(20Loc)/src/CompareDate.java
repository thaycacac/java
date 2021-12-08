
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *

 */
public class CompareDate {
    public static void main(String[] args) {
        //User enter first date
        Date firstDate = inputDate("Please enter the first date: ");
        //User enter second date
        Date secondDate = inputDate("Please enter the second date: ");
        //Compare and display
        CompareAndDisplay(firstDate, secondDate);
    }

    private static Date inputDate(String msg) {
        Scanner sc = new Scanner(System.in);
        String input;
        Date date;
        do {
            System.out.print(msg);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input could not be empty!!!");
                continue;
            } //check negative value return of checkContainCharacter is true or false
            else if(!checkContainCharacter(input)){
                // \d{1,2}: the number have 1 or 2 digit number
                //[/]: contain character /
                //\d{4}: the number must have 4 digit
                if (!input.matches("\\d{1,2}[/]\\d{1,2}[/]\\d{4}")) {
                System.out.println("Input is wrong format date");
                continue;
            }
            try {
                date = dateFormat.parse(input);
                break;
            } catch (ParseException exception) {
                System.out.println("Date doesn't existed!!");
            }
            }else{
                System.out.println("Contain special character. Please enter again!");
            }
        } while (true);
        return date;
    }

    private static void CompareAndDisplay(Date firstDate, Date secondDate) {
        if(firstDate.before(secondDate)){
            System.out.println("Date1 is before Date2");
        }else if(firstDate.after(secondDate)){
            System.out.println("Date1 is after Date2");
        }else{
            System.out.println("Date1 is equal Date2");
        }
    }
    
    
    private static boolean checkContainCharacter(String input){
        boolean isContain = false;
        //loop use to access each character of string from begining to the end
        for (int i = 0; i < input.length(); i++) {
           //check if character in index i is out range from character '/' to '9'
            if(!(input.charAt(i)>= '/' && input.charAt(i) <= '9')){
                isContain = true;
            }
        }
        return isContain;
    }

}
