package dal;

import dataobj.User;
import db.DBContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Thaycacac
 */
public class UserDAO {

    public User getUser(String username) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "select * from [user] where username = '" + username + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String user = rs.getString(1);
                String pass = rs.getString(2);
                int role = rs.getInt(3);
                User newUser = new User(sql, pass, role);
                return newUser;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
