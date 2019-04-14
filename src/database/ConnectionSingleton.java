package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {
    private static Connection connectionInstance;

    static {
        try {
            connectionInstance = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_oop","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance() {
        return connectionInstance;
    }

    public static Connection getTestInstance() {
        try {
            return connectionInstance = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_oop_test","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
