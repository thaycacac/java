package dal;

import db.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Thaycacac
 */
public class StudentQuizAnswerDAO {

    public void addStudentQuizAnswer(int sutdentId, int sessionId, int quizId,
            String questionId, String answerId) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql = "insert StudentQuizAnswer (StudentID, QuizSessionID, QuizID, QuestionID, AnswerID, CreatedTime) \n"
                    + "values (?, ?, ?, ?, ?, GETDATE())";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, sutdentId);
            stmt.setInt(2, sessionId);
            stmt.setInt(3, quizId);
            stmt.setString(4, questionId);
            stmt.setString(5, answerId);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
