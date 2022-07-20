/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;

/**
 *
 * @author Trung.Hoang
 */
public class Asset extends AssetID implements Serializable {

    protected String name, color;
    protected int price, quantity;
    protected double weight;

    public Asset() {
    }

    public Asset(String assetID) {
        this.assetID = assetID;
    }

    public Asset(String name, String color, int price, double weight, int quantity) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
    }

    public Asset(String assetID, String name, String color, int price, double weight, int quantity) {
        super(assetID);
        this.name = name;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "\n     " + super.toString() + "; Name = " + this.name + "; Color = " + this.color
                + "; Price = " + this.price + "; Weight = " + this.weight
                + "; Quantity = " + this.quantity;

    }

    @Override
    protected void createAssetID(String id) {
        super.createAssetID(id);
        this.name = Utils.getString("Name of Asset: ");
        this.color = Utils.getString("Color of Asset: ");
        this.price = Utils.getGreaterThan0("Price of Asset: ");
        this.weight = Utils.getDouble("Weight of Asset: ");
        this.quantity = Utils.getGreaterThan0("Quantity of Asset: ");
    }

    @Override
    protected void updateAssetID(String id) {
        super.updateAssetID(id);
        this.name = Utils.updateString(this.name, "Update Name of Asset: ");
        this.color = Utils.updateString(this.color, "Update Color of Asset: ");
        this.price = Utils.updateGreaterThan0(this.price, "Update Price of Asset: ");
        this.weight = Utils.updateDouble(this.weight, "Update Weight of Asset: ");
        this.quantity = Utils.updateGreaterThan0(this.quantity, "Update Quantity of Asset: ");
    }
}
