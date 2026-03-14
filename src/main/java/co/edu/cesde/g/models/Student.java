package co.edu.cesde.g.models;

public class Student extends Person {
    private long studentId;
    private String birthDate;

    public Student() {
        super();
    }

    // Constructor abierto.... aqui esta toda la informacion de Person y Student.
    public Student(long userId, String code, String documentNumber, String firstName, String lastName, Boolean status, long studentId, String birthDate) {
        // Super envía los datos a la clase abstracta Person
        super(userId, code, documentNumber, firstName, lastName, status);
        this.studentId = studentId;
        this.birthDate = birthDate;
    }

    // Aqui se el contrato de la clase abstracta
    @Override
    public String getRole() {
        return "STUDENT";
    }
}



