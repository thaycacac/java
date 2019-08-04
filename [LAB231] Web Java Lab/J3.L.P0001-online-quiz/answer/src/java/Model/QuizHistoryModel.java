package Model;

import Helper.DbConnectionHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.Entity.*;

/**
 *
 * @author minhndse04560
 */
public class QuizHistoryModel {

    private Connection connection;

    public void addEntry(int id, int numOfQuiz, int correctAnswer) throws Exception {
        PreparedStatement statement = null;
        try {
            connection = DbConnectionHelper.getConnection();
            statement = connection.prepareStatement("insert into QuizHistory (studentId, numOfQuiz, correctAnswer) values (?,?,?)");
            statement.setInt(1, id);
            statement.setInt(2, numOfQuiz);
            statement.setInt(3, correctAnswer);
            statement.execute();
        } catch (Exception ex) {
            throw ex;
        } finally {
            DbConnectionHelper.closeConnection(connection);
            if ((statement != null) && (!statement.isClosed())) {
                statement.close();
            }
        }
    }

    public List<QuizHistory> getAllEntry() throws Exception {
        List<QuizHistory> history = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DbConnectionHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select QuizHistory.*, Users.username from QuizHistory inner join Users on QuizHistory.studentId = Users.id;");
            while (resultSet.next()) {
                history.add(new QuizHistory(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getInt("numOfQuiz"), resultSet.getInt("correctAnswer")));
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            DbConnectionHelper.closeConnection(connection);
            if ((resultSet != null) && (!resultSet.isClosed())) {
                resultSet.close();
            }
            if ((statement != null) && (!statement.isClosed())) {
                statement.close();
            }
        }
        return history;
    }
}
