/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Trung.Hoang
 */
public class Car extends Vehicle{
    
    private String type;
    private int yearOfManufacture;

    public Car() {
    }

    public Car(String vehicleId) {
        this.vehicleId = vehicleId;
    }
    
    public Car(String type, int yearOfManufacture) {
        this.type = type;
        this.yearOfManufacture = yearOfManufacture;
    }

    public Car(String type, int yearOfManufacture, String name, String color, String vehicleId, String brand, int price) {
        super(name, color, vehicleId, brand, price);
        this.type = type;
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getType() {
        return type;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
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

    public void setType(String type) {
        this.type = type;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
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

    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "+)  CAR: \n" + super.toString() + " ; Type - " + this.type + " ; Year of manufacture - " + this.yearOfManufacture + "\n";
    }

    @Override
    protected void updateVehicle() {
        super.updateVehicle();
        this.type = Utils.updateType(this.type, "Update Type (Sport/Travel/Common): ");
        this.yearOfManufacture = Utils.updateYear(this.yearOfManufacture, "Update Year of manufacture: ");
    }

    @Override
    protected void createVehicle() {
        super.createVehicle();
        this.type = Utils.getType("Type (Sport/Travel/Common): ");
        this.yearOfManufacture = Utils.getYear("Year of manufacture: ");
    }    
}