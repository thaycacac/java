/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dataobj.Job;
import db.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Thaycacac
 */
public class JobDAO {

    public void insert(String title, String com, int exp, String des) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Job (JobTitle, CompanyCode, YearExp, Description) VALUES (?, ?, ?, ?)";
            PreparedStatement s = con.prepareStatement(sql);
            s.setString(1, title);
            s.setString(2, com);
            s.setInt(3, exp);
            s.setString(4, des);
            s.executeUpdate();
            s.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Job> select() {
        ArrayList<Job> listj = new ArrayList<>();
Connection con = null;
        DBContext db = new DBContext();
        CompanyDAO comd = new CompanyDAO();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Job";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String com = rs.getString(3);
                
                String nameCom = comd.getname(com);
                int exp =rs.getInt(4);
                String des =rs.getString(5);
                Job j = new Job(id, title, nameCom, exp, des);
                listj.add(j);
            }
            rs.close();
            stmt.close();
            con.close();
            return listj;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void delete(int id) {
Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql = "DELETE FROM Job WHERE id = "+id;
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return;
    }

    public void update(int id, String title, String com, int exp, String des) {
Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql = "UPDATE Job SET JobTitle = ?, CompanyCode = ?, YearExp = ?, Description = ? WHERE id = " +id;
            PreparedStatement s = con.prepareStatement(sql);
            s.setString(1, title);
            s.setString(2, com);
            s.setInt(3, exp);
            s.setString(4, des);
            s.executeUpdate();
            s.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public Job getJob(String id){
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Job where id = " +id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int idt = rs.getInt(1);
                String title = rs.getString(2);
                String com = rs.getString(3);
                int exp =rs.getInt(4);
                String des =rs.getString(5);
                Job j = new Job(idt, title, com, exp, des);
return j;
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
