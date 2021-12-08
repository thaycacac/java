/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author SY NGUYEN
 */
public class Order {

    private String fruitId;
    private String fruitName;
    private int quantity;
    private double price;

    public Order() {
    }

    public Order(String fruitId, String fruitName, int quantity, double price) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getFruitId() {
        return fruitId;
    }

    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
