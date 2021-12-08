

import Entity.Fruit;
import Entity.Order;
import java.util.ArrayList;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
        ArrayList<Fruit> lf = new ArrayList<>();
        Fruit f1 = new Fruit("P01", "Banana", 20, 25, "Viet Nam");
        Fruit f2 = new Fruit("P02", "Apple", 25, 50, "Viet Nam");
        Fruit f3 = new Fruit("P03", "Lemon", 10, 100, "Viet Nam");
        lf.add(f1);
        lf.add(f2);
        lf.add(f3);
        Hashtable<String, ArrayList<Order>> ht = new Hashtable<>();
        //loop until user want to exit
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.createFruit(lf);
                    Manager.displayListFruit(lf);
                    break;
                case 2:
                    Manager.updateFruit(lf);
                    break;
                case 3:
                    Manager.viewOrder(ht);
                    break;
                case 4:
                    Manager.shopping(lf, ht);                  
                    break;
                default:
                    System.out.println("THANKS FOR USING MY SYSTEMS");
                    return;
            }
        }
    }

}
