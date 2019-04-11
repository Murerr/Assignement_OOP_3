package user;

public class Teacher extends Person {
    private String degree;

    public Teacher(int id, Name name, String email, String phone, String degree) {
        super(id, name, email, phone);
        this.degree = degree;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
