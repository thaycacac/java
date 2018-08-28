package dal;

import dataobj.Company;
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
public class CompanyDAO {

    public void insertCompany(String code, String name) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Company (CompanyCode, CompanyName) "
                    + "VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, code);
            stmt.setString(2, name);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Company> selectCompany() {
        ArrayList<Company> listCom = new ArrayList<>();
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
                listCom.add(com);
            }
            rs.close();
            stmt.close();
            con.close();
            return listCom;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
