package co.edu.cesde.g.models;

public abstract class Person {
    protected long userId;
    protected String code;
    protected String documentNumber;
    protected String firstName;
    protected String lastName;
    protected Boolean status;

    public Person() {}

    public Person(long userId, String code, String documentNumber, String firstName, String lastName, Boolean status) {
        this.userId = userId;
        this.code = code;
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }

    //  Mètodos abstratos
    public abstract String getRole();

    // Aqui se implementa los Getting y setting
    public long getUserId() { return userId; }
    public String getCode() { return code; }
    public String getDocumentNumber() { return documentNumber; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Boolean getStatus() { return status; }

    public void setUserId(long userId) { this.userId = userId; }
    public void setCode(String code) { this.code = code; }
    public void setDocumentNumber(String documentNumber) { this.documentNumber = documentNumber; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setStatus(Boolean status) { this.status = status; }

    @Override
    public String toString() {
        return "Person { ID: " + userId + ", Name: " +
                firstName + " " +
                lastName + ", Role: " + getRole() + " }";
    }
}