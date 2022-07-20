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
public class Motorbike extends Vehicle{
    
    private String license;
    private int speed;
    private static final String MAKE_SOUND = "Tin tin tin";

    public Motorbike() {
    }

    public Motorbike(String license, int speed) {
        this.license = license;
        this.speed = speed;
    }

    public Motorbike(String license, int speed, String name, String color, String vehicleId, String brand, int price) {
        super(name, color, vehicleId, brand, price);
        this.license = license;
        this.speed = speed;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "+)  MOTORBIKE: \n" + super.toString() + " ; Required license - " + this.license 
                + " ; Speed - " + this.speed + " ; Sound - " + this.MAKE_SOUND + "\n";
    }

    @Override
    protected void updateVehicle() {
        super.updateVehicle();
        this.license = Utils.updateYesNo(this.license, "Update Required license (Yes/No): ");
        this.speed = Utils.updateGreaterThan0(this.speed, "Update Speed: ");
    }

    @Override
    protected void createVehicle() {
        super.createVehicle();
        this.license = Utils.getYesNo("Required license (Yes/No): ");
        this.speed = Utils.getGreaterThan0("Speed: ");
    }   
}