package co.edu.cesde.g.models;

public class Student extends Person{
    private String birthDate;
     public  Student(){
         //A qui se genera el constructor vacio
         super();
     }
     //Aqui se genera constructor lleno
    public Student(long userId, String code, String documentNumber, String firstName, String lastName, Boolean status, String birthDate) {
        super(userId, code, documentNumber, firstName, lastName, status);
        this.birthDate = birthDate;
    }

    //Aqui se genera los Seting y Geting
    public String getBirthDate() {
        return birthDate;
    }


    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    @Override
    public String toString() {
        return "Student = " + super.toString() +
                ", birthDate = " + birthDate; // Concatenamos la variable real
    }
}


