


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 */
class GetData {

    Scanner sc = new Scanner(System.in);

    public int getChoice(String msg, int min, int max) {
        int choice = 0;
        String input = "";
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Choice could not be empty. Please enter again!");
                continue;
            } else {
                try {
                    choice = Integer.parseInt(input);
                    //choice must be in range min to max
                    if (choice >= min && choice <= max) {
                        break;
                    } else {
                        System.out.println("Choice must be in range from " + min + " to " + max);
                        continue;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Choice must be positive integer number");
                    continue;
                }

            }
        } while (true);
        return choice;
    }

    public String getAcountNumber(String msg, String formatMsg) {
        String input;
        do {
            System.out.print(msg);
            try {
                input = sc.nextLine();
                //regex: allow input must be 10 digits from 0 to 9
                //check input match with regex 
                if (input.matches("^[0-9]{10}$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println(formatMsg);
            }
        } while (true);
        return input;
    }

    public String getPassword(String msg, String formatMsg) {
        String input;
        do {
            System.out.print(msg);
            try {
                input = sc.nextLine();
                //check length must larger than 8 and smaller than 31
                if (input.length() >= 8 && input.length() <= 31) {
                    //^[a-zA-Z0-9]*: check password start with character a-z 
                    //lower, upper, and digit in range 0 to 9
                    //([a-zA-Z]+[0-9]+): check password must contain character first
                    // and follow by digit from 0-9
                    // | : OR
                    //[0-9]+[a-zA-Z]+: check password must contain first
                    //follow by character
                    //[a-zA-Z0-9]*$: check password end with character a-z 
                    //lower, upper, and digit in range 0 to 9
                    if (input.matches("^[a-zA-Z0-9]*(([a-zA-Z]+[0-9]+)|[0-9]+[a-zA-Z]+)[a-zA-Z0-9]*$")) {
                        break;
                    } else {
                        throw new Exception();
                    }
                } else {
                    throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println(formatMsg);
            }
        } while (true);

        return input;
    }

    public String getCapcha(String msg, String errorMsg) {
        String input = "";
        System.out.print(msg);
        try {
            input = sc.nextLine();
            if (input.isEmpty()) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println(errorMsg);
        }

        return input;
    }
}
