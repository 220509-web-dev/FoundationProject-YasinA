// Packages
package dev.GGCritics.Utilities;
//Imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// Main method
public class ConnectionFactoryUtility {

    private static ConnectionFactoryUtility instance;

    private ConnectionFactoryUtility() {
        super();
    }

    public static ConnectionFactoryUtility getInstance() {
        if (instance == null) {
            instance = new ConnectionFactoryUtility();
        }
        return instance;
    }

    public static Connection getConnection() throws SQLException {
    try {
        Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
        System.out.println("Class not found");
        e.printStackTrace();
    }

    String url = "jdbc:postgresql://localhost:9999/";
    String username = "postgres";
    String password = "revature";

    return DriverManager.getConnection(url, username, password);
    }
}
//        try {
//            String dbInfo = System.getenv("DB_CONNECTION");
//            Connection connection = DriverManager.getConnection(dbInfo);
//            return connection;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
