package co.edu.cesde.g.models;
public class Student extends Person {
    private Long studentId;
    private String birthDate;

    public Student() {
        super();
    }

    public Student(Long userId, String code, String documentNumber, String firstName, String lastName, Boolean status, long studentId, String birthDate) {
        super(userId, code, documentNumber, firstName, lastName, status);
        this.studentId = studentId;
        this.birthDate = birthDate;
    }

    @Override
    public String getRole() {
        return "STUDENT";
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}