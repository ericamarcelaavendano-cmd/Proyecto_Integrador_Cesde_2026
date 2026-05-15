package co.edu.cesde.g.models;

import java.time.LocalDate;

public class Student extends Person {
    private Long studentId;
    private LocalDate birthDate;

    public Student() {
        super();
    }

    public Student(Long userId, String code, String documentNumber, String firstName, String lastName, Boolean status, Long studentId, LocalDate birthDate) {
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Student = " + super.toString() +
                ", StudentId = " + studentId +
                ", BirthDate = " + birthDate;
    }
}