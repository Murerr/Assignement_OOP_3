package school;

import user.Student;
import user.Teacher;

import java.util.ArrayList;

public class Module {
    private String name;
    private String code;
    private Teacher teacher;
    private ArrayList<Student> students;

    public Module(String name, String code, Teacher teacher, ArrayList<Student> students) {
        this.name = name;
        this.code = code;
        this.teacher = teacher;
        this.students = students;
    }

    public Module(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }



}
