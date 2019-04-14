package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import database.ConnectionSingleton;
import database.DatabaseController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

class StudentControllerTest {

    private DatabaseController databaseController;
    private Connection connectionToDatabase;

    @Before
    void setUp() {
        connectionToDatabase =  ConnectionSingleton.getTestInstance();
        databaseController = new DatabaseController(connectionToDatabase);
    }


    @Test
    public void connectToDatabase() {
            Connection connection = databaseController.getConnection();
            assertEquals(connection,connectionToDatabase);
    }

    @Test
    public void createADatabase() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("createDatabase.sql"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String query = sb.toString();
            Statement stmt = databaseController.getConnection().createStatement();
            stmt.executeLargeUpdate(query);
            br.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}