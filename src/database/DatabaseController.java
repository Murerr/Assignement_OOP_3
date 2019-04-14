package database;

import school.Classes;
import school.Module;
import user.Name;
import user.Student;
import user.Teacher;

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
        try{
            Statement stmt = connection.createStatement();
            String query = "UPDATE `Student` "
                    + "SET " +
                    "`name`=" + "'" + student.getName().getFirstName() + "'" + "," +
                    "`lastName`=" + "'" + student.getName().getLastName() + "'" + "," +
                    "`dob`=" + "'" + student.getDob() + "'" + "," +
                    "`email`=" + "'" + student.getEmail() + "'" + "," +
                    "`phone`=" + "'" + student.getPhone() + "'" +
                    " WHERE `idStudent` =" + studentId;

            System.out.println(query);

            stmt.executeUpdate(query);

        } catch (Exception e){
            e.printStackTrace();
        }
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
    public void updateClasses(int classesId,Classes classes) {
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

    @Override
    public ArrayList<Teacher> getTeachersInDatabase() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `Teacher`");
            ArrayList<Teacher> teacherList = new ArrayList<>();
            while (rs.next()){

                Teacher teacher = new Teacher(
                        rs.getInt("idTeacher"),
                        new Name(rs.getString("name"),rs.getString("lastname")),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("degree"));
                teacherList.add(teacher);

            }
            return teacherList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteTeacher(int teacherId) {
        try{
            Statement stmt = connection.createStatement();
            String query =
                    "DELETE FROM `Teacher` WHERE `idTeacher` ="+teacherId+";";
            System.out.println(query);
            stmt.executeUpdate(query);

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void addTeacher(Teacher teacher) {
        try{
            Statement stmt = connection.createStatement();
            String query = "INSERT INTO `Teacher` (`name`, `lastname`, `email`, `phone`, `degree`) "
                    + "VALUES (" +
                    "'" + teacher.getName().getFirstName() + "'," +
                    "'" + teacher.getName().getLastName() + "', " +
                    "'" + teacher.getEmail() + "'," +
                    "'" + teacher.getPhone() + "'," +
                    "'" + teacher.getDegree() + "')";
            System.out.println(query);

            stmt.executeUpdate(query);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateTeacher(int teacherId, Teacher teacher) {
        try{
            Statement stmt = connection.createStatement();
            String query = "UPDATE `Teacher` "
                    + "SET " +
                    "`name`=" + "'" + teacher.getName().getFirstName() + "'" + "," +
                    "`lastName`=" + "'" + teacher.getName().getLastName() + "'" + "," +
                    "`degree`=" + "'" + teacher.getDegree() + "'" + "," +
                    "`email`=" + "'" + teacher.getEmail() + "'" + "," +
                    "`phone`=" + "'" + teacher.getPhone() + "'" +
                    " WHERE `idTeacher` =" + teacherId;

            System.out.println(query);

            stmt.executeUpdate(query);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Module> getModuleInDatabase() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `Module` INNER JOIN Grades on Module.idModule = Grades.fk_idModule INNER JOIN Teacher on fk_idTeacher = Teacher.idTeacher GROUP BY Module.moduleName  \n" +
                    "ORDER BY `Grades`.`score` DESC;");
            ArrayList<Module> moduleList = new ArrayList<>();
            while (rs.next()){

                Module module = new Module(
                        rs.getInt("idModule"),
                        rs.getString("moduleName"),
                        rs.getString("code"),
                        new Name(rs.getString("name"),rs.getString("lastName")),
                        rs.getInt("score"));
                moduleList.add(module);
            }
            return moduleList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteModule(int moduleId) {
        try{
            Statement stmt = connection.createStatement();
            String query =
                    "DELETE FROM `Module` WHERE `Module`.`idModule` ="+moduleId+";";
            stmt.executeUpdate(query);

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void addModule(Module module) {
        try{
            Statement stmt = connection.createStatement();
            Random randomNumber = new Random();

            // INSERT INTO `Module`(`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5])
            String query = "INSERT INTO `Module` (`moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) "
                    + "VALUES (" +
                    "'" + module.getName() + "'," +
                    "'" + module.getCode() + "', " +
                    "'" + randomNumber.nextInt(50)+1 + "'," +
                    "'" + randomNumber.nextInt(50)+1 + "')";
            System.out.println(query);

            stmt.executeUpdate(query);

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateModule(int moduleId,Module module) {
        try{
            Statement stmt = connection.createStatement();
            String query = "UPDATE `Module` "
                    + "SET " +
                    "`idModule`=" + "'" + module.getId() + "'" + "," +
                    "`code`=" + "'" + module.getCode() + "'" + "," +
                    "`moduleName`=" + "'" + module.getName() + "'" +
                    " WHERE `idModule` =" + moduleId;

            System.out.println(query);

            stmt.executeUpdate(query);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
