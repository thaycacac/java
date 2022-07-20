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
public abstract class Vehicle implements Serializable {

    protected String name, color, vehicleId, brand;
    protected int price;

    public Vehicle() {
    }

    public Vehicle(String name, String color, String vehicleId, String brand, int price) {
        this.name = name;
        this.color = color;
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    protected void createVehicle() {
        this.vehicleId = Utils.getString("Vehicle ID: ");
        this.name = Utils.getString("Name: ");
        this.brand = Utils.getString("Brand: ");
        this.color = Utils.getColor("Color (Blue/Green/Red): ");
        this.price = Utils.getGreaterThan0("Price: ");
    }

    protected void updateVehicle() {
        String newId, currentId;
        currentId = this.vehicleId;
        do {
            newId = Utils.updateString(this.vehicleId, "Update Vehicle ID: ");
            if (currentId.equals(newId)) {
                System.out.println("Duplicated vehicle ID, input again!");
            } else {
                this.vehicleId = newId;
            }
        } while (currentId.equalsIgnoreCase(newId));
        this.name = Utils.updateString(this.name, "Update Name: ");
        this.brand = Utils.updateString(this.brand, "Update Brand: ");
        this.color = Utils.updateColor(this.color, "Update Color (Blue/Green/Red): ");
        this.price = Utils.updateGreaterThan0(this.price, "Update Price: ");
    }

    @Override
    public String toString() {
        return "Vehicle ID - " + this.vehicleId + " ; Name - " + this.name
                + " ; Brand - " + this.brand + " ; Color - " + this.color
                + " ; Price - " + this.price;
    }

    @Override
    public boolean equals(Object obj) {
        return this.vehicleId.equals(((Vehicle) obj).getVehicleId());
    }
}
