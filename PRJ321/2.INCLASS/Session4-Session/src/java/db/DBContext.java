package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Thaycacac
 */
public class DBContext {

    public Connection getConnection() throws SQLException {
        try {
            Connection con = null;
            // Step 1
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Step 2
            String url = "jdbc:sqlserver://localhost:1433; databaseName=PRJ321; user = sa; password = 123456";
            con = DriverManager.getConnection(url);
            return con;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
