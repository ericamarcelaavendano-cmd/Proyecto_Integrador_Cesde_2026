package co.edu.cesde.g.models;

// Se eliminó el import de Person porque están en el mismo paquete

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world");
        Person person = new Person();
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();

        person.setFirstName("Erica");
        person.setFirstName("Laura");

        System.out.println("Nombre actual: " + person.getFirstName());

        person.setFirstName("Mariana");

        System.out.println("Datos finales de person: " + person.toString());

    }
}