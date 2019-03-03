/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thaycacac
 */
public class Test {

    public static void main(String[] args) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            if (con != null) {
                System.out.println("connected");
            } else {
                System.out.println("fail connect");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
