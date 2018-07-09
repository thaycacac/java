package J2SP0117;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            this.con = db.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet getData(String sql) {
        ResultSet rs = null;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
        }
        return null;
    }

    public PreparedStatement getPS(String sql) {
        try {
            return con.prepareStatement(sql);
        } catch (SQLException ex) {
            return null;
        }
    }
}
