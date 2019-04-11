package database;

import user.Name;
import user.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseController  implements DatabaseQueries{
    private Connection connection;

    public DatabaseController(Connection connection){
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public ArrayList<Student> getStudentsInDatabase() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `Student`JOIN Classes ON Student.fk_idClasses = Classes.idClasses");
            ArrayList<Student> studentList = new ArrayList<>();
            while (rs.next()){

                Student student = new Student(
                        rs.getInt("idStudent"),
                        new Name(rs.getString("name"),rs.getString("lastname")),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("dob"),
                        rs.getString("classname"));
                studentList.add(student);

            }
            return studentList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteStudent(int studentId) {
        try{
            //TODO FIX DATABASE CONSTRAINT ERROR;
            // HACK : SET GLOBAL FOREIGN_KEY_CHECKS=0
            Statement stmt = connection.createStatement();
            String query =
                    "DELETE FROM Student WHERE Student.idStudent= "+studentId+";";
            stmt.executeUpdate(query);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
