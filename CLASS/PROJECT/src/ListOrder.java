
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ListOrder implements IListOrder {

    private String customerId;
    List<Order> a = new ArrayList<>();
    Order o = new Order();

    Scanner in = new Scanner(System.in);

    //Check Customer ID Valid
    public boolean checkCustomerID(String id) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getCustomerId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    //Check Customer Id In Order
    public boolean checkCustomerId(String id) {
        if (o.checkCustomerID(id)) {
            return true;
        }
        return false;
    }
    
    //Check Customer Id In Order
    public boolean checkOrderId(String id) {
        if (o.checkOrderID(id)) {
            return true;
        }
        return false;
    }

    //Generate Customer ID
    public String generateCustomerID() {
        String id;
        String s = "QWERTYUIOPLKJHGFDSAZXCVBNM0987654321";
        do {
            Random r = new Random();
            id = "";
            for (int i = 0; i < 3; i++) {
                int k = r.nextInt(s.length());
                id += s.charAt(k);
            }
            if (checkCustomerID(id)) {
                return id;
            }
        } while (true);
    }

    //Get Date
    public String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        return dtf.format(localDate);
    }

    //Add An Order
    public void addOrder(Store p) {
        customerId = generateCustomerID();
        System.out.println("Customer ID: " + customerId);
        String date = getDate();
        System.out.println("Order Date: " + date);
        System.out.print("Enter customer name: ");
        String customerName = in.nextLine();//bug
        System.out.print("Enter customer address: ");
        String customerAddress = in.nextLine();
        p.print();
        char checkYn;
        o.addProduct(p, customerId, customerName, customerAddress, getDate());
        do {
            System.out.println("Add more product(y/n): ");
            checkYn = in.nextLine().charAt(0);
            if (checkYn == 'y') {
                o.addProduct(p, customerId, customerName, customerAddress, getDate());
            } else if (checkYn == 'n') {
                break;
            } else {
                System.out.println("Re-input");
            }
        } while (true);
    }

    //Print Order By Customer ID
    public void printByCustomerId(Store p, String id) {
        o.printByCustomerId(id);
    }
    
    //Print Order By Order ID

    @Override
    public void printByOrderId(Store p, String id) {
        o.printByOrderId(id);
    }
    

    //Print All Order
    public void print() {
        o.print();
    }

}
