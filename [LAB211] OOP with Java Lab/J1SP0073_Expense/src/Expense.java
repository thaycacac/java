/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Expense {
    
    private int ID; 
    private String date, content;
    private double amount;

    public Expense() {
    }

    public Expense(int ID, String date, double amount, String content) {
        this.ID = ID;
        this.date = date;
        this.amount = amount;
        this.content = content;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    
    


    @Override
    public String toString() {
        String out = String.format("%-4d%-15s%-15.2f%-20s", ID, date, amount, content);
        return out;
    }


}
