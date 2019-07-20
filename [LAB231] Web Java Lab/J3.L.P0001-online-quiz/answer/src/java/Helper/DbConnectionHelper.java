package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.InitialContext;

/**
 *
 * @author minhndse04560
 */
public class DbConnectionHelper {
    public static Connection connection;   
    private DbConnectionHelper() {}
    private static String connectionString;
    private static String user;
    private static String pass;
    
    public static void initConnection(String connectionString, String user, String pass) {
        DbConnectionHelper.connectionString = connectionString;
        DbConnectionHelper.user = user;
        DbConnectionHelper.pass = pass;
    }
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connection = DriverManager.getConnection(connectionString, user, pass);
        return connection;
    }
    
    public static void closeConnection(Connection connection) throws Exception {
        if ((connection != null) && (!connection.isClosed())) {
            connection.close();
        }
    }
}
