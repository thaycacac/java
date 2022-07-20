/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managetask;

/**
 *
 * @author LeSyThanhLong
 */
public class ManageTask {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Validate check = new Validate();
        Manager manage = new Manager();
        while (true) {
            System.out.println("1. Add task");
            System.out.println("2. Display tasks");
            System.out.println("3. Delete task");
            System.out.println("4. Quit");
            int option = check.inputInt("Your choice: ", 1, 4);
            //handing option
            switch (option) {
                case 1:
                    manage.addTask();
                    break;
                case 2:
                    manage.display();
                    break;
                case 3:
                    manage.removeTask();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

}
