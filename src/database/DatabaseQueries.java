package database;

import user.Student;

import java.sql.Connection;
import java.util.ArrayList;

public interface DatabaseQueries {

    ArrayList<Student> getStudentsInDatabase(Connection connection);
}
