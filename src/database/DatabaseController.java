package database;

import school.Classes;
import user.Name;
import user.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

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
            Statement stmt = connection.createStatement();
            String query =
                    "DELETE FROM Student WHERE Student.idStudent= "+studentId+";";
            stmt.executeUpdate(query);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void addStudent(Student student) {
        try{
            Statement stmt = connection.createStatement();

            int randomNumber = new Random().nextInt(50)+1;
            String query = "INSERT INTO `Student`(`name`, `lastName`, `dob`, `email`, `phone`, `fk_idClasses`) "
                    + "VALUES (" +
                    "'" + student.getName().getFirstName() + "'," +
                    "'" + student.getName().getLastName() + "', " +
                    "'" + student.getDob() + "'," +
                    "'" + student.getEmail() + "'," +
                    "'" + student.getPhone() + "'," +
                    "'" + randomNumber + "')";
            System.out.println(query);

            stmt.executeUpdate(query);

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateStudent(int studentId,Student student) {

    }

    @Override
    public ArrayList<Classes> getClassesInDatabase() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `Classes`;");
            ArrayList<Classes> classesList = new ArrayList<>();
            while (rs.next()){

                Classes classes = new Classes(
                        rs.getInt("idClasses"),
                        rs.getString("classname"),
                        new ArrayList<Student>());
                classesList.add(classes);

            }
            return classesList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteClasses(int classesId) {
        try{
            Statement stmt = connection.createStatement();
            String query =
                    "DELETE FROM `Classes` WHERE `Classes`.`idClasses` ="+classesId+";";
            stmt.executeUpdate(query);

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void addClasses(Classes classes) {
        try{
            Statement stmt = connection.createStatement();
            String query = "INSERT INTO `Classes`(`classname`) "
                    + "VALUES (" +
                    "'" + classes.getName() + "')";
            System.out.println(query);

            stmt.executeUpdate(query);

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateClasses(int classesId,Classes classes) { //UPDATE `Classes` SET `idClasses`=[value-1],`classname`=[value-2] WHERE Classes.idClasses =
        try{
            Statement stmt = connection.createStatement();
            String query = "UPDATE `Classes` "
                    + "SET " +
                    "`idClasses`=" + "'" + classes.getId() + "'" + "," +
                    "`classname`=" + "'" + classes.getName() + "'" +
                    " WHERE `idClasses` =" + classesId;

            System.out.println(query);

            stmt.executeUpdate(query);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
