/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dataobj.Subject;
import db.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Thaycacac
 */
public class SubDAO {

    public ArrayList<Subject> select(int id) {
        ArrayList<Subject> lu = new ArrayList<>();
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT s.code, s.id, s.name, s.credit, s.lastUpdated, s.actived\n" +
"                   FROM semester se \n" +
"                 inner join subject s\n" +
"                on s.id = se.id " + ((id != 0) ? "WHERE se.id = '" + id + "'" : "");
     
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int suid = rs.getInt(1);
                int seid = rs.getInt(2);
                String sub = rs.getString(3);
                int cre = rs.getInt(4);
                Date date = rs.getDate(5);
                boolean active = rs.getBoolean(6);
                Subject su = new Subject(suid, seid, sub, cre, date, active);
                lu.add(su);
            }
            rs.close();
            stmt.close();
            con.close();
            return lu;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
