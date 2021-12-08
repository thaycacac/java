
import java.util.Scanner;


public class Item {

    private String name;
    private double price;
    private double discount;

    public Item(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public Item() {
    }
    
    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public String toString() {
        return name + " " + price + " (-" + discount + ")";
    }
    public void inputItem (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name Item :");
        this.name = sc.nextLine();
        System.out.println("Price :");
        sc = new Scanner(System.in);
        this.price = sc.nextDouble();  
        System.out.println("Discount:");
        sc = new Scanner(System.in);
        this.discount = sc.nextDouble();
    }
}
