import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author thaycacac
 */
public class DAO {

    DBContext db;
    Connection con;

    public DAO() {
    }

    public DAO(DBContext db) {
        this.db = db;
        try {
            this.con = db.getConnection();
        } catch (Exception ex) {
            System.out.println("Can't conect");
        }
    }

    public ResultSet getData(String sql) {
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    public PreparedStatement getPS(String sql) throws SQLException {
        return con.prepareStatement(sql);
    }
}
