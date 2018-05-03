
import java.util.Scanner;

public class Main {
    //Password  problem, given main

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter user role: ");
        String role = in.nextLine();
        System.out.print("Enter user password: ");
        String password = in.nextLine();
        Password p = new Password(password, role);
        while (!p.isValidPassword()) {
            System.out.print("Please enter a valid password: ");
            p.setPassword(in.nextLine());
        }
        System.out.println("Thanks you, info of your account ");
        System.out.println("User role: " + p.getRole());
        System.out.println("User password: " + p.getPassword());
        System.out.println("Password code: " + p.getPasswordCode());
    }

}
