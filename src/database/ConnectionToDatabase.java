package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDatabase {
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

    private ConnectionToDatabase() {
    }
}
