package school;

import user.Student;

import java.util.ArrayList;

/**
 *  A Class Object
 */
public class Classes {
    private int id;
    private String name;
    private ArrayList<Student> students;

    /**
     * @param id The class ID
     * @param name The class name
     * @param students A list of students in that class
     */
    public Classes(int id,String name, ArrayList<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
