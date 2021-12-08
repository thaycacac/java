
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *

 */
public class GetData {
    Scanner sc = new Scanner(System.in);
    int getInt(String msg, int min, int max) {
        String input;
        int output;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input couldn't be empty!");
                continue;
            } else {
                try {
                    output = Integer.parseInt(input);
                    //check input must be in range min to max
                    if (output <= max && output >= min) {
                        break;
                    } else {
                        throw new Exception();
                    }
                }catch(NumberFormatException numex){
                    System.out.println("Input must be integer!");
                }catch(Exception error){
                    System.out.println("Input must be in range "+ min +" to " + max);
                }
            }
        }while(true);
    return output;
    }

    int getMatrix(String msg) {
        String input;
        int output;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input couldn't be empty!");
                continue;
            } else {
                try {
                    output = Integer.parseInt(input);
                    break;
                }catch(NumberFormatException numex){
                    System.out.println("Value of matrix is digit");
                }
            }
        }while(true);
    return output;
    }
}
