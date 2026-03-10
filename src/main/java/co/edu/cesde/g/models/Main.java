package co.edu.cesde.g.models;

public class Main {
    public static void main(String[] args) {

        System.out.println(" SISTEMA REGISTRO");

        // 1. CONSTRUCTOR CERRADO (Usando tus Setters)
        Person person = new Person();
        person.setFirstName("Erica");
        person.setLastName("Avendaño");
        person.setDocumentNumber("101010");
        person.setStatus(true);

        // 2. CONSTRUCTOR ABIERTO (Enviando todos los datos de una vez)
        Person person2 = new Person(100, "2430", "12345", "Ana", "Avendaño" ,true);

        // 3. PRUEBA DE SALIDA
        System.out.println("Persona 1 (Cerrado + Set): " + person.getFirstName());
        System.out.println("Persona 2 (Abierto completo): " + person2.getFirstName());

        System.out.println(person.toString());
        System.out.println(person2.toString());

        //AGREGAR MAS PERSONAS

        Person person3 = new Person();
        person3.setFirstName("Jose");
        System.out.println("Persona 3: " + person3.getFirstName());
        System.out.println(person3.toString());

        Person person4 = new Person(200, "321", "54321","Diego", "Lopez", true );
        System.out.println("persona 4: (Abierto)" + person4.getFirstName());


    }
}