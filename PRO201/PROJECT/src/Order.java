
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Order {

    private String orderId;
    private String customerId;
    List<InformationOrder> a = new ArrayList<>();

    Scanner in = new Scanner(System.in);

    public Order() {
    }

    //Check Order ID Valid
    public boolean checkOrderID(String id) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getOrderId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    //Generate Order ID
    public String generateOrderID() {
        String id;
        String s = "QWERTYUIOPLKJHGFDSAZXCVBNM0987654321";
        do {
            Random r = new Random();
            id = "";
            for (int i = 0; i < 3; i++) {
                int k = r.nextInt(s.length());
                id += s.charAt(k);
            }
            if (checkOrderID(id)) {
                return id;
            }
        } while (true);
    }

    //Check Customer ID Valid
    public boolean checkCustomerID(String id) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getCustomerId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    //Add new product in order
    public void addProduct(Store p, String customerID, String customerName, String address, String date) {
        System.out.print("Enter product id: ");
        String id = in.nextLine();
        if (!p.checkProductId(id)) {
            System.out.print("Enter quantity: ");
            int quantity = Integer.parseInt(in.nextLine());
            a.add(new InformationOrder(generateOrderID(), customerID, customerName, id, p.getProductName(id), address, date, quantity, quantity * p.getProductPrice(id)));
        } else {
            System.out.println("Not found id!!!");
        }
    }

    //Print All Order
    public void print() {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Customer ID", "Order ID", "Name Customer", "Product ID", "Product Name", "Date", "Address", "Quantity", "Price");
        for (int i = 0; i < a.size(); i++) {
            System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15d%-15.2f\n", a.get(i).getCustomerId(), a.get(i).getOrderId(), a.get(i).getCustomerName(), a.get(i).getProductID(), a.get(i).getProductName(), a.get(i).getDate(), a.get(i).getAddress(), a.get(i).getQuantity(), a.get(i).getPrice());
        }
    }

    //Print Order By CustomId
    public void printByCustomerId(String id) {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Customer ID", "Order ID", "Name Customer", "Product ID", "Product Name", "Date", "Address", "Quantity", "Price");
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getCustomerId().equals(id)) {
                System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15d%-15.2f\n", a.get(i).getCustomerId(), a.get(i).getOrderId(), a.get(i).getCustomerName(), a.get(i).getProductID(), a.get(i).getProductName(), a.get(i).getDate(), a.get(i).getAddress(), a.get(i).getQuantity(), a.get(i).getPrice());
            }
        }
    }
    
    //Print Order By OrderId
    public void printByOrderId(String id) {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Customer ID", "Order ID", "Name Customer", "Product ID", "Product Name", "Date", "Address", "Quantity", "Price");
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getOrderId().equals(id)) {
                System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15d%-15.2f\n", a.get(i).getCustomerId(), a.get(i).getOrderId(), a.get(i).getCustomerName(), a.get(i).getProductID(), a.get(i).getProductName(), a.get(i).getDate(), a.get(i).getAddress(), a.get(i).getQuantity(), a.get(i).getPrice());
                return;
            }
        }
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<InformationOrder> getA() {
        return a;
    }

    public void setA(List<InformationOrder> a) {
        this.a = a;
    }

    public Scanner getIn() {
        return in;
    }

    public void setIn(Scanner in) {
        this.in = in;
    }

}
