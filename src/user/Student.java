package user;

import school.Module;

import java.util.ArrayList;

public class Student extends Person implements Cloneable {
    String dob;
    ArrayList<Module> modules;

    public Student(Name name, String email, String phone, String dob, ArrayList<Module> modules) {
        super(name, email, phone);
        this.dob = dob;
        this.modules = modules;
    }
    public Student(Name name, String email, String phone, String dob) {
        super(name, email, phone);
        this.dob = dob;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    public Student clone() throws CloneNotSupportedException { return (Student) super.clone(); }
}
