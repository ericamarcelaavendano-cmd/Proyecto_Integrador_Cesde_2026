package repository.impl;

import co.edu.cesde.g.models.Student;
import repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

/*Esta clase cumple el contrato de la interfaz StudentRepository.
El implements obliga a tener todos los métodos definidos en la interfaz.*/
public class StudentRepositoryInMemory implements StudentRepository {

    private final List<Student> students;
    private Long nextStudentId;

    public StudentRepositoryInMemory() {
        this.students = new ArrayList<>(); // Crea una lista nueva al iniciar
        this.nextStudentId = 1L; // el contador empieza desde 1
    }

    // Aqui empezamos con los metodos e iniciamos con el metodo create - Crear
    @Override
    public Student create(Student student) {
        if (student == null) { // Si no viene ningún estudiante no hace nada
            return null;
        }
        if (existsByDocumentNumber(student.getDocumentNumber())) {
            return null; // Si ya existe ese documento no lo duplica
        }
        student.setStudentId(nextStudentId++);  // Asigna ID automático y suma 1 para el siguiente
        students.add(student); // Agrega el estudiante a la lista
        return student; // Retorna el estudiante creado
    }

    /*Metodo findAll Retorna una copia de la lista completa.
    Se hace copia para que nadie pueda modificar la lista original desde afuera.*/
    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    //Metodo findById
    @Override
    public Student findById(Long studentId) {
        if (studentId == null) {
            return null;  // Si el ID viene vacío no busca
        }
        for (Student student : students) {  // Recorre uno por uno
            if (studentId.equals(student.getStudentId())) { // Si encuentra el ID
                return student; // Retorna ese estudiante
            }
        }
        return null;  // Si no encontró nada retorna null
    }

    //Metodo findByDocumentNumber
    @Override
    public Student findByDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.isBlank()) { // Si el documento viene vacío no busca
            return null;
        }
        for (Student student : students) {
            if (documentNumber.equals(student.getDocumentNumber())) {
                return student; // Retorna el estudiante si encuentra el documento
            }
        }
        return null; // Si no encontró nada retorna null


    }

    // Metodo update - Actualizar
    @Override
    public boolean update(Student studentupdate) {
        if (studentupdate == null || studentupdate.getStudentId() == null) {
            return false;  // Si no viene estudiante o no tiene ID no actualiza
        }
        for (Student student : students) {
            if (!student.getStudentId().equals(studentupdate.getStudentId())
                    && student.getDocumentNumber().equals(studentupdate.getDocumentNumber())) {
                return false; // Si otro estudiante ya tiene ese documento no actualiza
            }
        }
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(studentupdate.getStudentId())) {
                students.set(i, studentupdate); // Reemplaza el estudiante en esa posición
                return true;   // Actualización exitosa
            }
        }
        return false; // Si no encontró el estudiante retorna false

    }

    // Metodo Delete - Eliminar
    @Override
    public boolean delete(Long studentId) {
        Student student = findById(studentId); // Primero busca el estudiante
        if (student == null) {
            return false; // Si no existe no puede eliminar
        }
        return students.remove(student); // Lo elimina de la lista
    }

    // Metodo existsByDocumentNumber
    @Override
    public boolean existsByDocumentNumber(String documentNumber) {
        return findByDocumentNumber(documentNumber) != null;
        // Si findByDocumentNumber retorna algo significa que existe
    }

    @Override
    public int count() {
        return students.size(); // Retorna cuántos estudiantes hay en la lista
    }
}
