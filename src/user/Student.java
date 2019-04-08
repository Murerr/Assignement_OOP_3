package user;

public class Student extends Person implements Cloneable {
    private String dob;

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

    public Student clone() throws CloneNotSupportedException { return (Student) super.clone(); }
}
