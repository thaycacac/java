/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Entity.Product;
import Entity.Storekeeper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 *
 */
public class Manager {

    GetDataInput getdata = new GetDataInput();
    Display display = new Display();

    void sort(ArrayList<Product> productList) {
        System.out.println("=========Sort===========");
        display.displayProductList(productList);
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                //compare expiry date of o1 with expiry o2
                if(o1.getExpiryDate().equals(o2.getExpiryDate())){
                    return o1.getDateOfManu().compareTo(o2.getDateOfManu());
                }else{
                    return o1.getExpiryDate().compareTo(o2.getExpiryDate());
                }
            }
        });
        display.displayProductList(productList);

    }

    void updateProduct(ArrayList<Storekeeper> storeList, ArrayList<Product> productList) {
        System.out.println("=========Update Product===========");
        if (!productList.isEmpty()) {
            display.displayProductList(productList);
            int idToUpdate = getdata.getInt("Enter product's ID: ", "Input out of range.", 0, Integer.MAX_VALUE);
            int index = searchById(productList, idToUpdate);
            //compare value of variable index with -1
            if (index == -1) {
                System.out.println("Product is not found!");
            } else {
                int id;
                do {
                    id = getdata.getInt("Enter product's ID: ", "Input out of range.", 0, Integer.MAX_VALUE);
                    boolean isExist = checkDuplicateIdProduct(productList, id);
                    //check value of variable is true or false
                    if (isExist) {
                        System.out.println("Id product is exist. Please enter again!");
                        continue;
                    } else {
                        break;
                    }
                } while (true);

                String productName = getdata.getString("Enter product's name: ", "", "");
                String productLocation = getdata.getString("Enter product's location: ", "", "");
                int price = getdata.getInt("Enter product's price: ", "Price must be a positive number.", 1, Integer.MAX_VALUE);
                Date dateOfManu;
                Date expiryDate;
                do {
                    dateOfManu = getdata.getDate("Enter product's manufacture date[dd/MM/YYYY]: ");
                    Date now = new Date();
                    //compare dateOfManu with today
                    if (dateOfManu.after(now)) {
                        System.out.println("Date of manufacture must be in the past");
                        continue;
                    } else {
                        break;
                    }
                } while (true);

                do {
                    expiryDate = getdata.getDate("Enter product's expiry date[dd/MM/YYYY]: ");
                    //compare variable expiryDate with dateOfManu
                    if (expiryDate.before(dateOfManu)) {
                        System.out.println("Expiry date must be after date of manufacture");
                        continue;
                    } else {
                        break;
                    }
                } while (true);

                String category = getdata.getString("Enter category: ", "", "");
                Storekeeper store = null;
                do {
                    display.displayStorekeeper(storeList);
                    String msg = "Choice must be in range [" + 1 + "-" + (storeList.size()) + "]";
                    int storekeeperChoice = getdata.getInt("Choose storekeeper: ", msg, 1, storeList.size());
                    //loop use to access each element of arraylist from begining to the end
                    for (Storekeeper storeInlist : storeList) {
                        //compare id of storekeeper input with id storekeeper in list
                        if (storeInlist.getStorekeeperID() == storekeeperChoice) {
                            store = storeInlist;
                            break;
                        }
                    }
                } while (store == null);

                Date receiptDate;
                do {
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String manufactoringDate = dateFormat.format(dateOfManu);
                    String dateofexpiryDate = dateFormat.format(expiryDate);
                    receiptDate = getdata.getDate("Enter receipt date: ");
                    //compare receiptDate with dateOfManu or expiryDate
                    if (receiptDate.before(dateOfManu) || receiptDate.after(expiryDate)) {
                        System.out.println("Receipt date must be from " + manufactoringDate + " to "
                                + dateofexpiryDate);
                        continue;
                    } else {
                        break;
                    }
                } while (true);
                productList.set(index, new Product(id, productName, productLocation, price, expiryDate, dateOfManu, category, store, receiptDate));
                display.displayProductList(productList);
            }
        } else {
            System.out.println("List is empty!");
        }
    }

    void search(ArrayList<Product> productList) {
        System.out.println("=========Search===========");
        System.out.println("Menu Search:");
        System.out.println("1. Search by Name");
        System.out.println("2. Search by category");
        System.out.println("3. Search by storekeeper");
        System.out.println("4. Search by receipt date");
        int choice = getdata.getInt("Your choice:", "Choice must be in range [1-6]", 1, 4);
        switch (choice) {
            case 1:
                searchByName(productList);
                break;
            case 2:
                searchByCategory(productList);
                break;
            case 3:
                searchByStorekeeper(productList);
                break;
            case 4:
                searchByReceiptdate(productList);
                break;
        }

    }

    void searchByName(ArrayList<Product> productList) {
        System.out.println("=========Search By Name===========");
        if (productList.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            String SearchName = getdata.getString("Enter name for searching: ", "", "");
            ArrayList<Product> resultList = new ArrayList<>();
            //loop use to access each element of arraylist from begining to the end
            for (Product product : productList) {
                //compare variable SearchName with name of product in list
                if (product.getProductName().equals(SearchName)) {
                    resultList.add(product);
                }
            }

            if (resultList.isEmpty()) {
                System.out.println("Product is not found!");
            } else {
                display.displayProductList(resultList);
            }
        }
    }

    void searchByCategory(ArrayList<Product> productList) {
        System.out.println("=========Search By Category===========");
        if (productList.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            String Searchcategory = getdata.getString("Enter category for searching: ", "", "");
            ArrayList<Product> resultList = new ArrayList<>();
            //loop use to access each element of arraylist from begining to the end
            for (Product product : productList) {
                //compare variable of category input with category in list
                if (product.getCategory().equals(Searchcategory)) {
                    resultList.add(product);
                }
            }

            if (resultList.isEmpty()) {
                System.out.println("Product is not found!");
            } else {
                display.displayProductList(resultList);
            }
        }
    }

    void searchByStorekeeper(ArrayList<Product> productList) {
        System.out.println("=========Search By Storekeeper===========");
        if (productList.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            String storekeeperName = getdata.getString("Enter storekeeper name for searching: ", "", "");
            ArrayList<Product> resultList = new ArrayList<>();
            //loop use to access each element of arraylist from begining to the end
            for (Product product : productList) {
                //compare variable of storekeeper input with storekeeper in list
                if (product.getStorekeeper().getStorekeeperName().equals(storekeeperName)) {
                    resultList.add(product);
                }
            }

            if (resultList.isEmpty()) {
                System.out.println("Product is not found!");
            } else {
                display.displayProductList(resultList);
            }
        }
    }

    void searchByReceiptdate(ArrayList<Product> productList) {
        System.out.println("=========Search By Receipt Date===========");
        if (productList.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            Date receiptdate = getdata.getDate("Enter receipt date for search: ");
            ArrayList<Product> resultList = new ArrayList<>();
            //loop use to access each element of arraylist from begining to the end
            for (Product product : productList) {
                //compare variable of receiptdate input with receiptdate of product in list
                if (product.getReceiptDate().equals(receiptdate)) {
                    resultList.add(product);
                }
            }

            if (resultList.isEmpty()) {
                System.out.println("Product is not found!");
            } else {
                display.displayProductList(resultList);
            }
        }
    }

    int searchById(ArrayList<Product> productList, int id) {
        int resultindex = -1;
        if (productList.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            //loop use to access each element of arraylist from begining to the end
            for (Product product : productList) {
                //compare variable id with product id in list
                if (product.getProductId() == id) {
                    resultindex = productList.indexOf(product);
                    break;
                }
            }
        }
        return resultindex;
    }

    boolean checkDuplicateIdProduct(ArrayList<Product> productList, int id) {
        boolean isExist = false;
        //loop use to access each element of arraylist from begining to the end
        for (Product product : productList) {
            //compare variable id with product id in list
            if (product.getProductId() == id) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }

    void addProduct(ArrayList<Storekeeper> storeList, ArrayList<Product> productList) {
        System.out.println("=========Add Product===========");
        display.displayProductList(productList);
        int ProductId;
        do {
            ProductId = getdata.getInt("Enter product's id: ", "Input out of range.", 0, Integer.MAX_VALUE);
            boolean isExist = checkDuplicateIdProduct(productList, ProductId);
            if (isExist) {
                String answer = getdata.getString("Product is exist. Do you want to add new product?[y|n]: ",
                        "Answer just accept[y] or [n]", "[yn]");
                if (answer.equals("y")) {
                    continue;
                } else {
                    return;
                }
            } else {
                break;
            }
        } while (true);

        String productName = getdata.getString("Enter product's name: ", "", "");
        String productLocation = getdata.getString("Enter product's location: ", "", "");
        int price = getdata.getInt("Enter product's price: ", "Price must be a positive number.", 1, Integer.MAX_VALUE);
        Date dateOfManu;
        Date expiryDate;
        do {
            dateOfManu = getdata.getDate("Enter product's manufacture date[dd/MM/YYYY]: ");
            Date now = new Date();
            //compare date of maniplulate with today
            if (dateOfManu.after(now)) {
                System.out.println("Date of manufacture must be in the past");
                continue;
            } else {
                break;
            }
        } while (true);

        do {
            expiryDate = getdata.getDate("Enter product's expiry date[dd/MM/YYYY]: ");
            //compare expiryDate with today
            if (expiryDate.before(dateOfManu)) {
                System.out.println("Expiry date must be after date of manufacture");
                continue;
            } else {
                break;
            }
        } while (true);

        String category = getdata.getString("Enter category: ", "", "");
        Storekeeper store = null;
        do {
            display.displayStorekeeper(storeList);
            int storekeeperChoice = getdata.getInt("Choose storekeeper: ", "List store not have a store.", 1, storeList.size());
            //loop use to access each element of arraylist from begining to the end
            for (Storekeeper storeInlist : storeList) {
                if (storeInlist.getStorekeeperID() == storekeeperChoice) {
                    store = new Storekeeper(storeInlist.getStorekeeperID(), storeInlist.getStorekeeperName());
                    break;
                }
            }
        } while (store == null);

        Date receiptDate;
        do {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String manufactoringDate = dateFormat.format(dateOfManu);
            String dateofexpiryDate = dateFormat.format(expiryDate);
            receiptDate = getdata.getDate("Enter receipt date: ");
            //compare receiptDate with dateOfManu and expiryDate
            if (receiptDate.before(dateOfManu) || receiptDate.after(expiryDate)) {
                System.out.println("Receipt date must be from " + manufactoringDate + " to "
                        + dateofexpiryDate);
                continue;
            } else {
                break;
            }
        } while (true);

        Product newProduct = new Product(ProductId, productName, productLocation, price, expiryDate, dateOfManu, category, store, receiptDate);
        productList.add(newProduct);
    }

    boolean checkDuplicateStore(ArrayList<Storekeeper> storelist, String storeName) {
        boolean isDuplicate = false;
        //loop use to access each element of arraylist from begining to the end
        for (Storekeeper storekeeper : storelist) {
            //compare StorekeeperName with storekeeper name in list
            if (storekeeper.getStorekeeperName().equals(storeName)) {
                isDuplicate = true;
                break;
            }
        }
        return isDuplicate;
    }

    void addStore(ArrayList<Storekeeper> storeList) {

        System.out.println("=========Add Storekeeper===========");
        display.displayStorekeeper(storeList);
        String store;
        store = getdata.getString("Enter new storekeeper: ", "", "");
        boolean isDuplicate = checkDuplicateStore(storeList, store);
        if (isDuplicate) {
            System.out.println("Store is exist");
        } else {
            if (storeList.isEmpty()) {
                Storekeeper storekeeper = new Storekeeper(1, store);
                storeList.add(storekeeper);
            } else {
                int indexOfLastElement = storeList.size()-1;
                int id = storeList.get(indexOfLastElement).getStorekeeperID();
                Storekeeper storekeeper = new Storekeeper(id+1, store);
                storeList.add(storekeeper);
            }
        }
    }

}
