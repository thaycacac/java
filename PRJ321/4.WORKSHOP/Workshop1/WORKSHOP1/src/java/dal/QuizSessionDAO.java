package dal;

import dataobj.QuizSession;
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
public class QuizSessionDAO {

    public QuizSession getQuizSession(String Code) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM QuizSession WHERE Code = '" + Code + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String code = rs.getString(2);
                int quizId = rs.getInt(3);
                int startBy = rs.getInt(4);
                Date startedDate = rs.getDate(5);
                Date endDate = rs.getDate(6);
                boolean isInProgress = rs.getBoolean(7);
                QuizSession qs = new QuizSession(id, code, quizId, startBy, startedDate, endDate, isInProgress);
                return qs;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }
}
