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
public class Request extends AssetID implements Serializable {

    private String rID, employeeID;
    private int quantity;
    private String requestDateTime;

    public Request() {
    }

    public Request(String rID) {
        this.rID = rID;
    }

    public Request(String rID, String employeeID, int quantity, String requestDateTime) {
        this.rID = rID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.requestDateTime = requestDateTime;
    }

    public Request(String rID, String assetID, String employeeID, int quantity, String requestDateTime) {
        super(assetID);
        this.rID = rID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.requestDateTime = requestDateTime;
    }

    public String getrID() {
        return rID;
    }

    public void setrID(String rID) {
        this.rID = rID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(String requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "\n     Request ID = " + this.rID + "; Asset ID = " + this.assetID
                + "; Employee ID = " + this.employeeID + "; Quantity = " + this.quantity
                + "; Date Time = " + this.requestDateTime;
    }

//    protected void createRequestByHand(String reID, String aID, String eID) {
//        this.rID = reID;
//        this.assetID = aID;
//        this.employeeID = eID;
//        this.quantity = Utils.getGreaterThan0("Quantity: ");
//        this.requestDateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
//    }
    
    protected void createRequest(String reID, String aID, String eID, int q) {
        this.rID = reID;
        this.assetID = aID;
        this.employeeID = eID;
        this.quantity = q;
        this.requestDateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
    }

}
