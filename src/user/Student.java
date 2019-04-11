package user;

public class Student extends Person implements Cloneable {
    private String dob;
    private String className;

    public Student(Name name, String email, String phone, String dob, String className) {
        super(name, email, phone);
        this.dob = dob;
        this.className = className;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Student clone() throws CloneNotSupportedException { return (Student) super.clone(); }
}
