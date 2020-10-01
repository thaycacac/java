/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.Date;

/**
 *
 * @author hailiang194
 */
public class SalaryHistory {
    private double salary;
    private Date updatedDate;

    public SalaryHistory(double salary, Date updatedDate) {
        this.salary = salary;
        this.updatedDate = updatedDate;
    }

    public double getSalary() {
        return salary;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    @Override
    public String toString() {
        return "SalaryHistory{" + "salary=" + salary + ", updatedDate=" + updatedDate + '}';
    }
    
    
}
