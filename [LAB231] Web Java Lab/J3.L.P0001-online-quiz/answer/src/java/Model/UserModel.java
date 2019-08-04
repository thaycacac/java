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
public class UserModel {

    private Connection connection;

    public UserModel() {
    }

    public User login(String userName, String password) throws Exception {
        User returnValue = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DbConnectionHelper.getConnection();
            statement = connection.prepareStatement("select * from Users where username=? and password=?");
            statement.setString(1, userName);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                returnValue = new User(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("email"), resultSet.getInt("type"));
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
        return returnValue;
    }

    public int validateNewUser(User user) throws Exception {
        int returnValue = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DbConnectionHelper.getConnection();
            statement = connection.prepareCall("select * from Users where username=? or email=?");
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("username").equals(user.getUserName())) {
                    returnValue = 1;
                    break;
                }
                if (resultSet.getString("email").equals(user.getEmail())) {
                    returnValue = 2;
                    break;
                }
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
        return returnValue;
    }

    public void addUser(User newUser) throws Exception {
        PreparedStatement ps = null;
        try {
            connection = DbConnectionHelper.getConnection();
            String query = "Insert into Users (username,password,email,type) values(?,?,?,?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, newUser.getUserName());
            ps.setString(2, newUser.getPassword());
            ps.setString(3, newUser.getEmail());
            ps.setInt(4, newUser.getType());
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        } finally {
            DbConnectionHelper.closeConnection(connection);
            if ((ps != null) && (!ps.isClosed())) {
                ps.close();
            }
        }
    }
}
