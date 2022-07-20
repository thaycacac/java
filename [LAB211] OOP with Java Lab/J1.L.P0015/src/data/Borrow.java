/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Trung.Hoang
 */
public class Borrow extends AssetID implements Serializable {

    private String bID, employyID, assetID;
    private String borrowDateTime;
    private int quantity;

    public Borrow() {
    }
    
    public Borrow(String bID,String assetID, String employyID, int quantity,  String borrowDateTime) {
        this.bID = bID;
        this.employyID = employyID;
        this.assetID = assetID;
        this.borrowDateTime = borrowDateTime;
        this.quantity = quantity;
    }

    public String getbID() {
        return bID;
    }

    public void setbID(String bID) {
        this.bID = bID;
    }

    public String getEmployyID() {
        return employyID;
    }

    public void setEmployyID(String employyID) {
        this.employyID = employyID;
    }

    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getBorrowDateTime() {
        return borrowDateTime;
    }

    public void setBorrowDateTime(String borrowDateTime) {
        this.borrowDateTime = borrowDateTime;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "\n     Borrow ID = " + this.bID + "; Asset ID = " + this.assetID + "; Employy ID = "
                + this.employyID + "; Quantity = " + this.quantity + "; Borrow Date Time = " + this.borrowDateTime;
    }

    protected void createBorrow(String brID, String aID, String eID) {
        this.bID = brID;
        this.assetID = aID;
        this.employyID = eID;
        this.quantity = Utils.getGreaterThan0("Quantity: ");
        this.borrowDateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
    }

    protected void insertBorrow(String brID, String aID, String eID, int q) {
        this.bID = brID;
        this.assetID = aID;
        this.employyID = eID;
        this.quantity = q;
        this.borrowDateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
    }

}
