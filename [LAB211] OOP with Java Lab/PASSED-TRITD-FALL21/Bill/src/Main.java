
import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");
        Item i1 = new Item("Apple", 2, 2);
        Item i2 = new Item("Phone", 200, 100);
        Item i3 = new Item("Banana", 3, 1);
        Employee employee = new Employee("TienAnh");
        int choice;
        Scanner sc = new Scanner(System.in);
        do {            
            System.out.println("1. Test GroceryBill");
            System.out.println("2. Test Employee");
            System.out.println("3. Test Item");
            System.out.println("4. Test DiscountBill");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Item i5 = new Item("non", 5, 6);
                    GroceryBill g = new GroceryBill(employee);
                    g.add(i5);
                    System.out.println("Add sucessful!");
                    break;
            }
        } while (choice <= 5 && choice >= 1);
    }
}
