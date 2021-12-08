
import java.util.ArrayList;

public class GroceryBill {

    private Employee clerk;
    private ArrayList<Item> items = new ArrayList<>();
    private double total;

    public GroceryBill() {
        
    }

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
        items = new ArrayList<>();
        total = 0.0;
    }

    public void add(Item i) {
        items.add(i);
        total += i.getPrice();
    }

    public double getTotal() {
        return total;
    }

    public Employee getClerk() {
        return clerk;
    }

    public void printReceipt() {
        System.out.println("list of items:");
        for (Item item : items) {
            System.out.println("\t" + item.toString());
        }
    }
}
