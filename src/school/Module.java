package school;

import user.Name;

/**
 *  A module
 */
public class Module {
    private int id;
    private String name;
    private String code;
    private Name teacher;
    private int averageGrade;

    /**
     * @param id THe module Id
     * @param name The module Name
     * @param code The Module Code 4 digits eg:1234
     * @param teacher The Teacher assigned to the module
     * @param averageGrade The average Grade of the module scored by students
     */
    public Module(int id, String name, String code, Name teacher, int averageGrade) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.teacher = teacher;
        this.averageGrade = averageGrade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Name getTeacher() {
        return teacher;
    }

    public void setTeacher(Name teacher) {
        this.teacher = teacher;
    }

    public int getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(int averageGrade) {
        this.averageGrade = averageGrade;
    }
}
