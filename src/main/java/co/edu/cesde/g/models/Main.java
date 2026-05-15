package co.edu.cesde.g.models;

import repository.impl.*;
import service.impl.*;
import service.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {


        System.out.println("  SISTEMA DE REGISTRO ACADÉMICO");

        // ========== ROLE ==========
        System.out.println("\n--- ROLES ---");
        RoleService roleService = new RoleServiceImpl(new RoleRepositoryInMemory());

        co.edu.cesde.g.models.Role role1 = new co.edu.cesde.g.models.Role();
        role1.setName("ADMIN");
        role1.setDescription("Administrador del sistema");

        co.edu.cesde.g.models.Role role2 = new co.edu.cesde.g.models.Role();
        role2.setName("TEACHER");
        role2.setDescription("Profesor del sistema");

        co.edu.cesde.g.models.Role r3 = new co.edu.cesde.g.models.Role();
        r3.setName("STUDENT");
        r3.setDescription("Estudiante del sistema");

        System.out.println("Creado: " + roleService.create(role1));
        System.out.println("Creado: " + roleService.create(role2));
        System.out.println("Creado: " + roleService.create(r3));
        System.out.println("Total roles: " + roleService.count());

        // ========== USER ==========
        System.out.println("\n--- USUARIOS ---");
        UserService userService = new UserServiceImpl(new UserRepositoryInMemory());

        co.edu.cesde.g.models.User u1 = new co.edu.cesde.g.models.User();
        u1.setUsername("erica123");
        u1.setEmail("erica@gmail.com");
        u1.setPasswordHash("123456");
        u1.setStatus(true);
        u1.setCreatedAt(LocalDateTime.now());

        System.out.println("Creado: " + userService.create(u1));
        System.out.println("Total usuarios: " + userService.count());

        // ========== USER ROLE ==========
        System.out.println("\n--- USER ROLES ---");
        UserRoleService userRoleService = new UserRoleServiceImpl(new UserRoleRepositoryInMemory());

        co.edu.cesde.g.models.UserRole ur1 = new co.edu.cesde.g.models.UserRole(1L, 1L);
        System.out.println("Creado: " + userRoleService.create(ur1));
        System.out.println("Total userRoles: " + userRoleService.count());

        // ========== PROGRAM ==========
        System.out.println("\n--- PROGRAMAS ---");
        ProgramService programService = new ProgramServiceImpl(new ProgramRepositoryInMemory());

        co.edu.cesde.g.models.Program p1 = new co.edu.cesde.g.models.Program();
        p1.setCode("IS-001");
        p1.setName("Ingeniería de Sistemas");

        System.out.println("Creado: " + programService.create(p1));
        System.out.println("Total programas: " + programService.count());

        // ========== PERIOD ==========
        System.out.println("\n--- PERIODOS ---");
        PeriodService periodService = new PeriodServiceImpl(new PeriodRepositoryInMemory());

        co.edu.cesde.g.models.Period per1 = new co.edu.cesde.g.models.Period();
        per1.setCode("2026-1");
        per1.setStartDate(LocalDate.parse("2026-01-15"));
        per1.setEndDate(LocalDate.parse("2026-06-15"));

        System.out.println("Creado: " + periodService.create(per1));
        System.out.println("Total periodos: " + periodService.count());

        // ========== SUBJECT ==========
        System.out.println("\n--- MATERIAS ---");
        SubjectService subjectService = new SubjectServiceImpl(new SubjectRepositoryInMemory());

        co.edu.cesde.g.models.Subject sub1 = new co.edu.cesde.g.models.Subject();
        sub1.setCode("MAT-001");
        sub1.setName("Matematicas");
        sub1.setCredits(3);
        sub1.setProgramId(1L);

        System.out.println("Creado: " + subjectService.create(sub1));
        System.out.println("Total materias: " + subjectService.count());

        // ========== GROUP ==========
        System.out.println("\n--- GRUPOS ---");
        GroupService groupService = new GroupServiceImpl(new GroupRepositoryInMemory());

        co.edu.cesde.g.models.Group g1 = new co.edu.cesde.g.models.Group();
        g1.setCode("GR-001");
        g1.setShift("MAÑANA");
        g1.setProgramId(1L);
        g1.setPeriodId(1L);

        System.out.println("Creado: " + groupService.create(g1));
        System.out.println("Total grupos: " + groupService.count());

        // ========== GROUP SUBJECT ==========
        System.out.println("\n--- GROUP SUBJECTS ---");
        GroupSubjectService groupSubjectService = new GroupSubjectServiceImpl(new GroupSubjectRepositoryInMemory());

        co.edu.cesde.g.models.GroupSubject gs1 = new co.edu.cesde.g.models.GroupSubject();
        gs1.setGroupId(1L);
        gs1.setSubjectId(1L);
        gs1.setTeacherId(1L);

        System.out.println("Creado: " + groupSubjectService.create(gs1));
        System.out.println("Total groupSubjects: " + groupSubjectService.count());

        // ========== STUDENT ==========
        System.out.println("\n--- ESTUDIANTES ---");
        StudentService studentService = new StudentServiceImpl(new StudentRepositoryInMemory());

        Student s1 = new Student();
        s1.setFirstName("Erica");
        s1.setLastName("Avendaño");
        s1.setDocumentNumber("101010");
        s1.setCode("ST-001");
        s1.setStatus(true);
        s1.setBirthDate(LocalDate.parse("2000-01-01"));

        System.out.println("Creado: " + studentService.create(s1));
        System.out.println("Total estudiantes: " + studentService.count());

        // ========== TEACHER ==========
        System.out.println("\n--- PROFESORES ---");
        TeacherService teacherService = new TeacherServiceImpl(new TeacherRepositoryInMemory());

        Teacher t1 = new Teacher();
        t1.setFirstName("Jorge");
        t1.setLastName("Diaz");
        t1.setDocumentNumber("707070");
        t1.setCode("PF-001");
        t1.setStatus(true);

        System.out.println("Creado: " + teacherService.create(t1));
        System.out.println("Total profesores: " + teacherService.count());

        // ========== ENROLLMENT ==========
        System.out.println("\n--- MATRICULAS ---");
        EnrollmentService enrollmentService = new EnrollmentServiceImpl(new EnrollmentRepositoryInMemory());

        co.edu.cesde.g.models.Enrollment e1 = new co.edu.cesde.g.models.Enrollment();
        e1.setStudentId(1L);
        e1.setGroupId(1L);
        e1.setPeriodId(1L);
        e1.setStatus(true);
        e1.setEnrolledAt(LocalDateTime.now());

        System.out.println("Creado: " + enrollmentService.create(e1));
        System.out.println("Total matriculas: " + enrollmentService.count());

        // ========== GRADE ==========
        System.out.println("\n--- CALIFICACIONES ---");
        GradeService gradeService = new GradeServiceImpl(new GradeRepositoryInMemory());

        co.edu.cesde.g.models.Grade gr1 = new co.edu.cesde.g.models.Grade();
        gr1.setStudentId(1L);
        gr1.setGroupSubjectId(1L);
        gr1.setFinalScore(8);
        gr1.setObservation("Buen desempeño");

        System.out.println("Creado: " + gradeService.create(gr1));
        System.out.println("Total calificaciones: " + gradeService.count());


        System.out.println("  SISTEMA CARGADO EXITOSAMENTE");

    }
}