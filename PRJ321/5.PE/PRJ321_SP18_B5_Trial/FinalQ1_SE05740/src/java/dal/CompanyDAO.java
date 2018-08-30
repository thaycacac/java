/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dataobj.Company;
import dataobj.Job;
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
public class CompanyDAO {
    public void insert(String code, String name){
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Company (CompanyCode, CompanyName) VALUES (?, ?)";
            PreparedStatement s = con.prepareStatement(sql);
            s.setString(1, code);
            s.setString(2, name);
            s.executeUpdate();
            s.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public ArrayList<Company> select(){
         ArrayList<Company> listj = new ArrayList<>();
Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Company";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String code = rs.getString(1);
                String name = rs.getString(2);
      
                Company com = new Company(code, name);
                listj.add(com);
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
    public String getname(String code){
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT CompanyName FROM Company where CompanyCode = '"+code+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString(1);
      return name;
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
