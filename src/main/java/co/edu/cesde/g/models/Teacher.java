package co.edu.cesde.g.models;

public class Teacher extends Person {
    private Long teacherId;
    private String specialization;

    public Teacher() {
        super();
    }

    public Teacher(Long userId, String code, String documentNumber, String firstName, String lastName, Boolean status, long teacherId) {
        super(userId, code, documentNumber, firstName, lastName, status);
        this.teacherId = teacherId;
    }

    @Override
    public String getRole() {
        return "TEACHER";
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    // El toString debe estar AQUÍ ADENTRO antes de la última llave
    @Override
    public String toString() {
        return "Teacher = " + super.toString() +
                ", TeacherId = " + teacherId;
    }
}