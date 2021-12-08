/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author hailiang194
 */
public class Worker implements Iterable<SalaryHistory> {

    private String code;
    private String name;
    private int age;
    private String workLocation;
    private ArrayList<SalaryHistory> salaryHistories;

    public Worker(String code, String name, int age, String workLocation) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.workLocation = workLocation;
        this.salaryHistories = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public double getCurrentSalary() {
        if (this.salaryHistories.isEmpty()) {
            return 0.0;
        }

        return this.salaryHistories.get(this.salaryHistories.size() - 1).getSalary();
    }

    public Date getCurrentSalaryUpdatedDate() {
        if (this.salaryHistories.isEmpty()) {
            return null;
        }

        return this.salaryHistories.get(this.salaryHistories.size() - 1).getUpdatedDate();
    }

    public SalaryHistory getLastestSalary() {
        return this.salaryHistories.get(this.salaryHistories.size() - 1);
    }

    public void updateSalary(SalaryHistory salary) {
        this.salaryHistories.add(salary);
    }

    public double getCurrentSalaryDifference() {
        if (this.salaryHistories.isEmpty()) {
            return 0.0;
        }

        int size = this.salaryHistories.size();
        if (size == 1) {
            return this.salaryHistories.get(size - 1).getSalary();
        }

        return this.salaryHistories.get(size - 1).getSalary() - this.salaryHistories.get(size - 2).getSalary();
    }

    @Override
    public String toString() {
        return "Worker{" + "code=" + code + ", name=" + name + ", age=" + age + ", workLocation=" + workLocation + '}';
    }

    @Override
    public Iterator<SalaryHistory> iterator() {
        return this.salaryHistories.iterator();
    }

}
