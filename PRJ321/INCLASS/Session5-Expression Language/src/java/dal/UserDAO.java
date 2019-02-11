package dal;

import dataobj.User;
import db.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Thaycacac
 */
public class UserDAO {

    public void addUser(User user) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            if (con != null) {
                PreparedStatement stmt = con.prepareStatement("insert into taker(username, firstname, lastname, password, email, gender)\n"
                        + "values (?, ?, ?, ?, ?, ?)");
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getFirstname());
                stmt.setString(3, user.getLastname());
                stmt.setString(4, user.getPassword());
                stmt.setString(5, user.getEmail());
                stmt.setInt(6, (user.isGender() == true) ? 1 : 0);

                stmt.executeUpdate();
                stmt.close();
                con.close();
            } else {
                System.out.println("fail connect");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String getPassword(String username) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select password from taker where username = '" + username + "'");
            while (rs.next()) {
                String password = rs.getString(1);
                return password;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public String getFullName(String username) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select firstname, lastname from taker where username = '" + username + "'");
            while (rs.next()) {
                String firstname = rs.getString(1);
                String lastname = rs.getString(2);
                return firstname + " " + lastname;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
