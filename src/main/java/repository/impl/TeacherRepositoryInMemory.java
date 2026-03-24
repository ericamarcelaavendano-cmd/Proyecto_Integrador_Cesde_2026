package repository.impl;

import co.edu.cesde.g.models.Teacher;
import repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

/*Esta clase cumple el contrato de la interfaz StudentRepository.
El implements obliga a tener todos los métodos definidos en la interfaz.*/
public class TeacherRepositoryInMemory implements TeacherRepository {

    private final List<Teacher> teachers;
    private Long nextTeacherId;

    public TeacherRepositoryInMemory() {
        this.teachers = new ArrayList<>(); // Crea una lista nueva al iniciar
        this.nextTeacherId = 1L; // el contador empieza desde 1
    }

    // Aqui empezamos con los metodos e iniciamos con el metodo create - Crear
    @Override
    public Teacher create(Teacher teacher) {
        if (teacher == null) { // Si no viene ningún profesor no hace nada
            return null;
        }
        if (existsByDocumentNumber(teacher.getDocumentNumber())) {
            return null; // Si ya existe ese documento no lo duplica
        }
        teacher.setTeacherId(nextTeacherId++);  // Asigna ID automático y suma 1 para el siguiente
        teachers.add(teacher);// Agrega el profesor a la lista
        return teacher; // Retorna el profesor creado
    }

    /*Metodo findAll Retorna una copia de la lista completa.
    Se hace copia para que nadie pueda modificar la lista original desde afuera.*/
    @Override
    public List<Teacher> findAll() {
        return new ArrayList<>(teachers);
    }

    //Metodo findBiId
    @Override
    public Teacher findById(Long teacherId) {
        if (teacherId == null) {
            return null;  // Si el ID viene vacío no busca
        }
        for (Teacher teacher : teachers) {  // Recorre uno por uno
            if (teacherId.equals(teacher.getTeacherId())) { // Si encuentra el ID
                return teacher; // Retorna ese profesor
            }
        }
        return null;  // Si no encontró nada retorna null
    }

    //Metodo findByDocumentNumber
    @Override
    public Teacher findByDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.isBlank()) { // Si el documento viene vacío no busca
            return null;
        }
        for (Teacher teacher : teachers) {
            if (documentNumber.equals(teacher.getDocumentNumber())) {
                return teacher; // Retorna el estudiante si encuentra el documento
            }
        }
        return null; // Si no encontró nada retorna null


    }

    // Metodo update - Actualizar
    @Override
    public boolean update(Teacher teacherupdate) {
        if (teacherupdate == null || teacherupdate.getTeacherId() == null) {
            return false;  // Si no viene estudiante o no tiene ID no actualiza
        }
        for (Teacher teacher : teachers) {
            if (!teacher.getTeacherId().equals(teacherupdate.getTeacherId())
                    && teacher.getDocumentNumber().equals(teacherupdate.getDocumentNumber())) {
                return false; // Si otro profesor ya tiene ese documento no actualiza
            }
        }
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getTeacherId().equals(teacherupdate.getTeacherId())) {
                teachers.set(i, teacherupdate); // Reemplaza el estudiante en esa posición
                return true;   // Actualización exitosa
            }
        }
        return false; // Si no encontró el profesor retorna false

    }

    // Metodo Delete - Eliminar
    @Override
    public boolean delete(Long teacherId) {
        Teacher teacher = findById(teacherId); // Primero busca el estudiante
        if (teacher == null) {
            return false; // Si no existe no puede eliminar
        }
        return teachers.remove(teacher); // Lo elimina de la lista
    }

    // Metodo existsByDocumentNumber
    @Override
    public boolean existsByDocumentNumber(String documentNumber) {
        return findByDocumentNumber(documentNumber) != null;
        // Si findByDocumentNumber retorna algo significa que existe
    }

    @Override
    public int count() {
        return teachers.size(); // Retorna cuántos profesores hay en la lista
    }
}
