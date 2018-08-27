package dal;

import dataobj.Answer;
import dataobj.Question;
import db.DBContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Thaycacac
 */
public class QuestionDAO {

    public ArrayList<Question> getListQuestion(int quizId) {
        ArrayList<Question> listQuestion = new ArrayList<>();
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT qn.ID, qn.Content FROM Question qn\n"
                    + "INNER JOIN QuestionQuiz qz\n"
                    + "ON qn.ID = qz.QuestionID\n"
                    + "WHERE qz.QuizID = " + quizId;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String content = rs.getString(2);
                AnswerDAO ansDao = new AnswerDAO();
                ArrayList<Answer> listAns = ansDao.getListAnswer(id);

                Question question = new Question(id, content, listAns);
                listQuestion.add(question);
            }
            return listQuestion;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
