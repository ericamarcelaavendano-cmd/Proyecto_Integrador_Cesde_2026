package co.edu.cesde.g.models;

public class Main {
    public static void main(String[] args) {

        System.out.println("SISTEMA DE REGISTRO ACADÉMICO COMPLETO");

        // --- SECCIÓN: 6 ESTUDIANTES ---

        // 3 Estudiantes con Constructor CERRADO (Tipo Student para usar todos los setters)
        Student s1 = new Student();
        s1.setFirstName("Erica");
        s1.setLastName("Avendaño");
        s1.setDocumentNumber("101010");
        s1.setStatus(true);
        s1.setStudentId(2026001l); // <-- ¡Ahora sí puedes usarlo!

        Student s2 = new Student();
        s2.setFirstName("Jose");
        s2.setLastName("Perez");
        s2.setDocumentNumber("202020");
        s2.setStatus(true);
        s2.setStudentId(2026002l);

        Student s3 = new Student();
        s3.setFirstName("Maria");
        s3.setLastName("Gomez");
        s3.setDocumentNumber("303030");
        s3.setStatus(false);
        s3.setStudentId(2026003l);

        // 3 Estudiantes con Constructor ABIERTO (Tipo Person para demostrar Polimorfismo)
        Person s4 = new Student(104l, "ST-004", "404040", "Luis", "Rodriguez", true, 202404, "2002-05-12");
        Person s5 = new Student(105l, "ST-005", "505050", "Ana", "Martinez", true, 202405, "2001-08-20");
        Person s6 = new Student(106l, "ST-006", "606060", "Carlos", "Ruiz", true, 202406, "1999-12-05");


        // --- SECCIÓN: 6 PROFESORES ---

        // 3 Profesores con Constructor CERRADO (Tipo Teacher)
        Teacher t1 = new Teacher();
        t1.setFirstName("Jorge");
        t1.setLastName("Diaz");
        t1.setDocumentNumber("707070");
        t1.setStatus(true);
        t1.setTeacherId(5001);

        Teacher t2 = new Teacher();
        t2.setFirstName("Marta");
        t2.setLastName("Sanchez");
        t2.setDocumentNumber("808080");
        t2.setStatus(true);
        t2.setTeacherId(5002);

        Teacher t3 = new Teacher();
        t3.setFirstName("Ricardo");
        t3.setLastName("López");
        t3.setDocumentNumber("909090");
        t3.setStatus(false);
        t3.setTeacherId(5003);

        // 3 Profesores con Constructor ABIERTO (Tipo Person)
        Person t4 = new Teacher(204, "PF-004", "111213", "Claudia", "Restrepo", true, 5004);
        Person t5 = new Teacher(205, "PF-005", "141516", "Andrés", "Castro", true, 5005);
        Person t6 = new Teacher(206, "PF-006", "171819", "Elena", "Moreno", true, 5006);


        System.out.println("Listado final");

        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());
        System.out.println(s4.toString());
        System.out.println(s5.toString());
        System.out.println(s6.toString());



        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(t3.toString());
        System.out.println(t4.toString());
        System.out.println(t5.toString());
        System.out.println(t6.toString());
    }
}