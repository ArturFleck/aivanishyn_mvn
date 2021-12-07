package homework_27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static final String DBName = "university";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DBName;
    private static final String USER = "root";
    private static final String pass = "root";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL, USER, pass);
            System.err.println("Connection successful");
        }catch (SQLException e){
            System.err.println("Connection FAIL !!!");
        }

        return connection;
    }
}
