package user;

public class Student extends Person {
    private String dob;
    private String className;

    public Student(int id, Name name, String email, String phone, String dob, String className) {
        super(id, name, email, phone);
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

}
