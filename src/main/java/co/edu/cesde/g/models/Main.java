package co.edu.cesde.g.models;
import repository.impl.StudentRepositoryInMemory;
import service.StudentService;
import service.impl.StudentServiceImpl;

public class Main {
    public static void main(String[] args) {

        System.out.println("SISTEMA DE REGISTRO ACADÉMICO COMPLETO");

        // Instancia del repositorio y servicio
        StudentRepositoryInMemory repository = new StudentRepositoryInMemory();
        StudentService service = new StudentServiceImpl(repository);

        //Agregar estudiantes


        //  SECCIÓN: 6 ESTUDIANTES

        // 3 Estudiantes con Constructor CERRADO
        Student s1 = new Student();
        s1.setFirstName("Erica");
        s1.setLastName("Avendaño");
        s1.setDocumentNumber("101010");
        s1.setCode("ST-001");
        s1.setStatus(true);
        s1.setBirthDate("2000-01-01");

        Student s2 = new Student();
        s2.setFirstName("Jose");
        s2.setLastName("Perez");
        s2.setDocumentNumber("202020");
        s2.setCode("ST-002");
        s2.setStatus(true);
        s2.setBirthDate("1999-03-15");

        Student s3 = new Student();
        s3.setFirstName("Maria");
        s3.setLastName("Gomez");
        s3.setDocumentNumber("303030");
        s3.setCode("ST-003");
        s3.setStatus(false);
        s3.setBirthDate("2001-07-22");

        // 3 Estudiantes con Constructor ABIERTO (Polimorfismo)
        Person s4 = new Student(104l, "ST-004", "404040", "Luis", "Rodriguez", true, 202404, "2002-05-12");
        Person s5 = new Student(105l, "ST-005", "505050", "Ana", "Martinez", true, 202405, "2001-08-20");
        Person s6 = new Student(106l, "ST-006", "606060", "Carlos", "Ruiz", true, 202406, "1999-12-05");

        // --- SECCIÓN: 6 PROFESORES ---

        // 3 Profesores con Constructor CERRADO
        Teacher t1 = new Teacher();
        t1.setFirstName("Jorge");
        t1.setLastName("Diaz");
        t1.setDocumentNumber("707070");
        t1.setStatus(true);
        t1.setTeacherId(5001l);

        Teacher t2 = new Teacher();
        t2.setFirstName("Marta");
        t2.setLastName("Sanchez");
        t2.setDocumentNumber("808080");
        t2.setStatus(true);
        t2.setTeacherId(5002l);

        Teacher t3 = new Teacher();
        t3.setFirstName("Ricardo");
        t3.setLastName("López");
        t3.setDocumentNumber("909090");
        t3.setStatus(false);
        t3.setTeacherId(5003l);

        // 3 Profesores con Constructor ABIERTO (Polimorfismo)
        Person t4 = new Teacher(204l, "PF-004", "111213", "Claudia", "Restrepo", true, 5004);
        Person t5 = new Teacher(205l, "PF-005", "141516", "Andrés", "Castro", true, 5005);
        Person t6 = new Teacher(206l, "PF-006", "171819", "Elena", "Moreno", true, 5006);

        // Crear estudiantes usando el servicio
        System.out.println("\n--- CREANDO ESTUDIANTES ---");
        System.out.println("Creado: " + service.create(s1));
        System.out.println("Creado: " + service.create(s2));
        System.out.println("Creado: " + service.create(s3));

        // Mostrar total
        System.out.println("\nTotal estudiantes registrados: " + service.count());

        // Buscar por documento
        System.out.println("\n--- BUSCAR POR DOCUMENTO ---");
        System.out.println(service.findByDocumentNumber("101010"));

        // Listar todos
        System.out.println("\n--- LISTADO COMPLETO ---");
        service.findAll().forEach(System.out::println);

        // Imprimir todos
        System.out.println("\n--- TOSTRING DE TODOS ---");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
        System.out.println(t5);
        System.out.println(t6);
    }
}