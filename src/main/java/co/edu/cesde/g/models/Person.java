package co.edu.cesde.g.models;

public class Person {
    private long userId;
    private String code;
    private String documentNumber;
    private String firstName;
    private String lastName;
    private Boolean status;

    // Constructor Vacío (¡Ya lo tenías, muy bien!)
    public Person() {}

    // Constructor con parámetros
    public Person(long userId, String code, String documentNumber, String firstName, String lastName, Boolean status) {
        this.userId = userId;
        this.code = code;
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }

    // --- GETTERS (Para obtener datos) ---
    public long getUserId() { return userId; }
    public String getCode() { return code; }
    public String getDocumentNumber() { return documentNumber; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Boolean getStatus() { return status; }

    // --- SETTERS (Para que funcionen person.set...) ---
    public void setUserId(long userId) { this.userId = userId; }
    public void setCode(String code) { this.code = code; }
    public void setDocumentNumber(String documentNumber) { this.documentNumber = documentNumber; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setStatus(Boolean status) { this.status = status; }

    @Override
    public String toString() {
        return "Person {" +
                "userId=" + userId +
                ", code='" + code + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
                '}';
    }
}