package co.edu.cesde.g.models;

public class Main {
    public static void main(String[] args) {

        System.out.println(" SISTEMA REGISTRO");

        // 1. CONSTRUCTOR CERRADO (Usando tus Setters)
        Person Student  = new Student();
        Student.setFirstName("Erica");
        Student.setLastName("Avendaño");
        Student.setDocumentNumber("101010");
        Student.setStatus(true);

        // 2. CONSTRUCTOR ABIERTO (Enviando todos los datos de una vez)
        Person person2 = new Student();

        // 3. PRUEBA DE SALIDA
        System.out.println("Persona 1 (Cerrado + Set): " + Student.getFirstName());
        System.out.println("Persona 2 (Abierto completo): " + person2.getFirstName());

        System.out.println(Student.toString());
        System.out.println(person2.toString());

        //AGREGAR MAS PERSONAS

        Person person3 = new Student();
        person3.setFirstName("Jose");
        System.out.println("Student 3: " + person3.getFirstName());
        System.out.println(person3.toString());

        Person person4 = new Student();
        System.out.println("persona 4: (Abierto)" + person4.getFirstName());


    }
}