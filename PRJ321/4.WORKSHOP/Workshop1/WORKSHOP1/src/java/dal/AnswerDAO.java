package dal;

import dataobj.Answer;
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
public class AnswerDAO {

    public ArrayList<Answer> getListAnswer(int questionId) {
        ArrayList<Answer> listAnswer = new ArrayList<>();
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Answer WHERE QuestionID = " + questionId;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                int quesId = rs.getInt(2);
                boolean isCorrectAnswer = rs.getBoolean(3);
                String contet = rs.getString(4);
                Answer ans = new Answer(id, questionId, contet, isCorrectAnswer);
                listAnswer.add(ans);
            }
            return listAnswer;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
