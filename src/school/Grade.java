package school;

import user.Name;

/**
 * A grade
 */
public class Grade {

    private int id;
    private int score;
    private String Module;
    private Name StudentName;

    /**
     * @param id
     * @param score
     * @param module
     * @param studentName
     */
    public Grade(int id, int score, String module, Name studentName) {
        this.id = id;
        this.score = score;
        Module = module;
        StudentName = studentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getModule() {
        return Module;
    }

    public void setModule(String module) {
        Module = module;
    }

    public Name getStudentName() {
        return StudentName;
    }

    public void setStudentName(Name studentName) {
        StudentName = studentName;
    }
}
