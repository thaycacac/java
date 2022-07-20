/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageworker;

/**
 *
 * @author LeSyThanhLong
 */
public class History extends Worker {
    
    private String status;
    private String date;
    
    public History() {
    }
    
    public History(String status, String date, String id, String name, int age,
            double salary, String workLocation) {
        super(id, name, age, salary, workLocation);
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
     
}
