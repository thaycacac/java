/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitshop;

/**
 *
 * @author LeSyThanhLong
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Manager manager = new Manager();
        Validation validation = new Validation();
        manager.generateFruit();
        while (true) {
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");
            int choice = validation.inputInt("Enter choice:", 1, 4);
            switch (choice) {
                case 1:
                    manager.createFruit();
                    break;
                case 2:
                    manager.viewOrder();
                    break;
                case 3:
                    manager.shopping();
                    break;
                case 4:
                    return;
            }
        }
    }

}
