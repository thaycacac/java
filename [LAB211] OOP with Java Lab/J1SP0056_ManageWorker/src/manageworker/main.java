/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageworker;

import java.util.ArrayList;

/**
 *
 * @author LeSyThanhLong
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Manager Manager = new Manager();
        Validate validate=new Validate();
        while (true) {
            System.out.println("1. Add worker.");
            System.out.println("2. Increase salary for worker.");
            System.out.println("3. Decrease for worker");
            System.out.println("4. Show adjusted salary worker information");
            System.out.println("5. Exist");
            System.out.print("Enter your choice: ");
            int choice = validate.inputInt("Enter choice", 1, 5);
            switch (choice) {
                case 1:
                    Manager.addWorker();
                    break;
                case 2:
                    Manager.changeSalary("UP");
                    break;
                case 3:
                    Manager.changeSalary("DOWN");
                    break;
                case 4:
                    Manager.printListHistory();
                    break;
                case 5:
                    return;
            }
        }
    }

}
