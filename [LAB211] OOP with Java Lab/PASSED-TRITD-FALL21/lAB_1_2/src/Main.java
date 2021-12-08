


import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("=====Add Item=====");
        Item i5 = new Item("lap", 200, 10);
        Item i = new Item("banana", 5, 0);
        Item i1 = new Item("apple", 5, 2);
        Item i2 = new Item("phone", 300, 50);
        Employee e = new Employee("TienAnh");
        DiscountBill d = new DiscountBill(e, true);
        d.add(i);
        d.add(i1);
        d.add(i2);
        d.add(i5);
        Item i6 = new Item();
        i6.inputItem();
        d.add(i6);
        System.out.println("Add successful!");
        d.printReceipt();
        System.out.println(e);
        System.out.println("===============================================");
        System.out.println("getDiscountCount: " + d.getDiscountCount());
        System.out.println("getDiscountAmount: " + d.getDiscountAmount());
        System.out.println("getDiscountPercent: " + df.format(d.getDiscountPercent()) + "%");
        System.out.println("getTotal: " + d.getTotal());
        
    }

}
