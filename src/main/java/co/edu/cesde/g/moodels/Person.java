package co.edu.cesde.g.moodels;

public class Person {
    //Aplicaciòn de atributos.
    long user_Id;
    String code;
    String documentNumber;
    String FirstName;
    String LastName;
    Boolean status;

    public long getUser_Id() {
        return user_Id;
    }

    public String getCode() {
        return code;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public Boolean getStatus() {
        return status;
    }

    public Person(long user_Id, String code, String documentNumber, String firstName, String lastName, Boolean status) {
        this.user_Id = user_Id;
        this.code = code;
        this.documentNumber = documentNumber;
        FirstName = firstName;
        LastName = lastName;
        this.status = status;

        //Fin de codigo
    }
}
