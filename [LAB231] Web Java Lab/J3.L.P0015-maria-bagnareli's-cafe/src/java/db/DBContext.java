package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thaycacac
 */
public class DBContext {

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
    private final String serverName = "localhost";
    private final String dbName = "J3LP0015";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "123456";

    public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
}

     
//public class DBContext {
//
//    InitialContext initCxt;
//    Context envirCxt;
//    String serverName;
//    String port;
//    String username;
//    String password;
//    String dbName;
//    String imgFolder;
//
//    public DBContext() throws Exception {
//        initCxt = new InitialContext();
//        envirCxt = (Context) initCxt.lookup("java:/comp/env");
//        serverName = (String) envirCxt.lookup("severName");
//        port = (String) envirCxt.lookup("port");
//        username = (String) envirCxt.lookup("username");
//        password = (String) envirCxt.lookup("password");
//        dbName = (String) envirCxt.lookup("dbName");
//        imgFolder = (String) envirCxt.lookup("imgFolder");
//    }
//
//    public Connection getConnection() throws Exception {
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        return DriverManager.getConnection("jdbc:sqlserver://" + serverName + ":" + port + ";databaseName=" + dbName, username, password);
//    }
//
//    public String getResource() throws Exception {
//        return imgFolder;
//    }
//
//}
