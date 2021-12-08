/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;
import Entity.*;
import java.util.ArrayList;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        GetDataInput getData = new GetDataInput();
        Display display = new Display();
        Manager manager = new Manager();
        int choice;
        ArrayList<Storekeeper> storeList = new ArrayList<>();
        ArrayList<Product> productList = new ArrayList<>();
        do{
            //Display menu
            display.displayMenu();
            //Get user choice
            choice = getData.getInt("Your choice:", "Choice must be in range [1-6]",1, 6);
            switch(choice){
                //1.Add Storekeeper
                case 1:
                    manager.addStore(storeList);
                    break;
                //2. Add product
                case 2:
                    manager.addProduct(storeList, productList);
                    break;
                //3. Update product
                case 3:
                    manager.updateProduct(storeList, productList);
                    break;
                //4. Search product by Name, Category, Storekeeper, ReceiptDate
                case 4:
                    manager.search(productList);
                    break;
                //5. Sort product by Expiry date, Date of manufacture
                case 5:
                    manager.sort(productList);
                    break;
                //5. Exit
                case 6:
                    System.exit(0);
                    break;
            }
        }while(true);
        
    }
}
