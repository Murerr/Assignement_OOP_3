package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 */
public class ConnectionSingleton {
    private static Connection connectionInstance;

    static {
        try {
            connectionInstance = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_oop","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return
     */
    public static Connection getInstance() {
        return connectionInstance;
    }

    /**
     * @return
     */
    public static Connection getTestInstance() {
        try {
            return connectionInstance = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
