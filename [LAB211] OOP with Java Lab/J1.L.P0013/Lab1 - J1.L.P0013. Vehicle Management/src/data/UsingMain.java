/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Trung.Hoang
 */
public class UsingMain {

    public static void main(String[] args) {

        int choice;
        VehicleList am = new VehicleList();
        String check = null;
        int count = 1;
        
        try {
            do {
                Utils.printMenu();
                choice = Utils.getInt("Enter your choice: ");
                switch (choice) {
                    case 1:
                        am.readFile(); // Load all data in the file into the collection.
                        break;
                        
                    case 2:
                        am.add();
                        count++;
                        System.out.println("");
                        break;
                        
                    case 3:
                        am.update();
                        count++;
                        System.out.println("");
                        break;
                        
                    case 4:
                        am.delete();
                        count++;
                        System.out.println("");
                        break;
                        
                    case 5:
                        am.search();
                        System.out.println("");
                        break;
                        
                    case 6:
                        am.output();
                        System.out.println("");
                        break;
                        
                    case 7:
                        am.writeFile();
                        count = 1; // When exiting the program will not ask to save again.
                        System.out.println("");
                        break;
                }
            } while (choice >= 1 && choice <= 7);
            
            if (choice >= 8 || choice <= 0) {
                // If you haven't saved it before (!=1), you will be prompted to save.
                if (count != 1) {
                    check = Utils.getYesNo("You have not saved it! Do you want to save it to a file (Yes/No): ");
                    if (check.equalsIgnoreCase("Yes")) {
                        am.writeFile();
                        System.out.println("\n------------------------------------- End Program -------------------------------------\n");
                    } else {
                        System.out.println("\n------------------------------------- End Program -------------------------------------\n");
                    }
                } else {
                    System.out.println("\n------------------------------------- End Program -------------------------------------\n");
                }
            }
        } catch (Exception e) {
        }
    }
}
