
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Store implements IStore {

    List<Product> a = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public Store() {
    }

    //Add new product in store
    public void addProduct(Product p) {
        a.add(p);
        System.out.println("Add a product success!!!");
    }

    //Check Prodduct ID Valid
    public boolean checkProductId(String id) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    //Generate Product ID
    public String generateProductID() {
        String id;
        String s = "QWERTYUIOPLKJHGFDSAZXCVBNM0987654321";
        do {
            Random r = new Random();
            id = "";
            for (int i = 0; i < 3; i++) {
                int k = r.nextInt(s.length());
                id += s.charAt(k);
            }
            if (checkProductId(id)) {
                return id;
            }
        } while (true);
    }

    //Update price of product
    public void updatePrice(String productId, double newPrice) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getId().equals(productId)) {
                a.get(i).setPrice(newPrice);
                System.out.println("Update success!!!");
                return;
            }
        }
        System.out.println("Not found id!!!");
    }

    //Sort all products by Price
    public void sortByPrice() {
        Collections.sort(a);
    }

    //Print Product
    public void print() {
        System.out.printf("%-15s%-15s%-15s\n", "Product ID", "Product Name", "Product Price");
        for (int i = 0; i < a.size(); i++) {
            System.out.printf("%-15s%-15s%-15.2f\n", a.get(i).getId(), a.get(i).getName(), a.get(i).getPrice());
        }
    }

    public String getProductName(String productId) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getId().equals(productId)) {
                return a.get(i).getName();
            }
        }
        return null;
    }
    
    public double getProductPrice(String productId) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getId().equals(productId)) {
                return a.get(i).getPrice();
            }
        }
        return 0;
    }
}
