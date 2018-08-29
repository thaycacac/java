/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dataobj.Contact;
import db.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Thaycacac
 */
public class ContactDAO {
    public void insert(String firstname, String lastname, int phonenumber, int groupId){
          Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Contact (firstname, lastname, phonenumber, groupId) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, firstname);
            stmt.setString(2, lastname);
            stmt.setInt(3, phonenumber);
            stmt.setInt(4, groupId);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Contact> select(){
        ArrayList<Contact> lista = new ArrayList<>();
         Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT id, firstname, lastname, phonenumber, groupId FROM Contact";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String fir = rs.getString(2);
                String las = rs.getString(3);
                int phone = rs.getInt(4);
                int group= rs.getInt(5);
                Contact cont = new Contact(id, fir, las, phone, group);
                lista.add(cont);
            }
            rs.close();
            stmt.close();
            con.close();
            return lista;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void edit(int id, String fir, String las, int phone, int group){
          Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql = "UPDATE Contact SET firstname = ? , lastname = ?, phonenumber = ? , groupId = ? WHERE id = " + id;
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, fir);
            stmt.setString(2, las);
            stmt.setInt(3, phone);
            stmt.setInt(4, group);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void delete(int id){
          Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql = "DELETE FROM Contact WHERE id = " + id;
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return;
    }
    public Contact getContact(int id){
         Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT firstname, lastname, phonenumber, groupId FROM Contact where id = "+id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String fir = rs.getString(1);
                String las = rs.getString(2);
                int phone = rs.getInt(3);
                int group= rs.getInt(4);
                Contact cont = new Contact(id, fir, las, phone, group);
                return cont;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
