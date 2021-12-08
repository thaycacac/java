
import java.util.ArrayList;

public class GroceryBill {
    public Employee clerk;
    public ArrayList<Item> items;
    public double total;

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
            System.out.println("\t"+item.toString());
        }
    }
}
