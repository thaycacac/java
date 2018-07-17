package com.context;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author THAYCACAC
 */
public class DAO {

    DBContext db;
    Connection con;

    public DAO(DBContext db, Connection con) {
        this.db = db;
        try {
            con = db.getConnection();
        } catch (Exception e) {
            System.err.println("Error connection.");
        }
        this.con = con;
    }

    public ResultSet getData(String sql) {
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();         
        } catch (Exception e) {
            System.err.println("Error connection.");
        }
        return rs;
    }

    public PreparedStatement getPS(String sql) {
        try {
            return con.prepareStatement(sql);
        } catch (Exception e) {
            return null;
        }
    }
}
