package dal;

import dataobj.Quiz;
import db.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Thaycacac
 */
public class QuizDAO {

    public Quiz getQuiz(int id) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT Title, CreatedDate, OwnedBy FROM Quiz WHERE id = " + id + "";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String title = rs.getString(1);
                Date createdDate = rs.getDate(2);
                int ownedBy = rs.getInt(3);
                Quiz quiz = new Quiz(id, title, createdDate, ownedBy);
                return quiz;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
