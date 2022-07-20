/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author Trung.Hoang
 */
public class Employee implements Serializable{
    
    public String employId, name, birthdate, role, sex, password;

    public Employee() {
    }

    public Employee(String employId, String name, String birthdate, String role, String sex, String password) {
        this.employId = employId;
        this.name = name;
        this.birthdate = birthdate;
        this.role = role;
        this.sex = sex;
        this.password = password;
    }

    public String getEmployId() {
        return employId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    protected void createEmploy() {
        this.employId = Utils.getString("Employ ID: ");
        this.name = Utils.getString("Name: ");
        this.birthdate = Utils.getDate("Birthdate: ");
        this.role = Utils.getString("Role: ");
        this.sex = Utils.getString("Sex: ");
        this.password = encode();
    }    

    protected String encode() {
        try {
            String input = Utils.getString("Password: ");
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } 
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public String toString() {
        return "Employee{" + "employId=" + employId + ", name=" + name + ", birthdate=" + birthdate + ", role=" + role + ", sex=" + sex + ", password=" + password + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.employId.equals(((Employee) obj).getEmployId());
    }
}
