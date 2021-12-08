/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Entity.*;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 */
public class Display {

    void displayMenu() {
        System.out.println("Main menu:");
        System.out.println("\t1. Add Storekeeper");
        System.out.println("\t2. Add product");
        System.out.println("\t3. Update product");
        System.out.println("\t4. Search product by Name, Category, Storekeeper, ReceiptDate");
        System.out.println("\t5. Sort product by Expiry date, Date of manufacture");
        System.out.println("\t6. Exit");
    }

    void displayStorekeeper(ArrayList<Storekeeper> storeList) {
        if (storeList.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            System.out.println("=========Storekeeper List===========");
            System.out.format("%-5s%-20s\n", "ID", "Name");
            //loop use to access each element of arraylist from begining to the end
            for (Storekeeper storekeeper : storeList) {
                System.out.format("%-5d%-20s\n", storekeeper.getStorekeeperID(), storekeeper.getStorekeeperName());
            }
        }
    }

    void displayProductList(ArrayList<Product> productList) {
        if (productList.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            System.out.println("==========Product List===========");
            System.out.format("%-3s%-15s%-10s%-10s%-20s%-20s%-15s%-20s%-15s\n", "Id", "Name","Location", "Price", "Manufacture date", "Expiry date",
                    "Category", "Storekeeper", "Receipt date");
            //loop use to access each element of arraylist from begining to the end
            for (Product product : productList) {
                displayProduct(product);
            }
        }
    }

    void displayProduct(Product product) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String expiryDate = dateFormat.format(product.getExpiryDate());
        String dateOfManu = dateFormat.format(product.getDateOfManu());
        String receiptDate = dateFormat.format(product.getReceiptDate());

        System.out.format("%-3d%-15s%-10s%-10d%-20s%-20s%-15s%-20s%-15s\n", product.getProductId(), product.getProductName(),product.getLocation(),
                product.getPrice(), dateOfManu, expiryDate, product.getCategory(), product.getStorekeeper(),
                receiptDate);
    }
}
