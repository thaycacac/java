/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managecandidate;

import java.util.ArrayList;

/**
 *
 * @author LeSyThanhLong
 */
public class man {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Manager manager = new Manager();
        Validation validation= new Validation();
        while (true) {
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            int choice = validation.inputInt("Enter your choice: ",1, 5);
            switch (choice) {
                case 1:
                    manager.createCandidate(0);
                    break;
                case 2:
                    manager.createCandidate(1);
                    break;
                case 3:
                    manager.createCandidate(2);
                    break;
                case 4:
                    manager.searchCandidate();
                    break;
                case 5:
                    return;
            }
        }

    }

}
