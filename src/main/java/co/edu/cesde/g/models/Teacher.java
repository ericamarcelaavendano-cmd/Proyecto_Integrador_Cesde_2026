package co.edu.cesde.g.models;

public class Teacher extends Person {
    private String birthDate;

    public Teacher() {
        super();
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    //Aqui se genera el constructor
    public Teacher(long userId, String code, String documentNumber, String firstName, String lastName, Boolean status, String birthDate) {
        super(userId, code, documentNumber, firstName, lastName, status);
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Teacher = " + super.toString() +
                ", birthDate = '" + birthDate + '\'';

    }
}
