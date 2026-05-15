package service.impl;

import co.edu.cesde.g.models.Teacher;
import repository.TeacherRepository;
import service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    // Metodo Crear
    @Override
    public Teacher create(Teacher teacher) {
        if (isInvalidTeacher(teacher) || teacherRepository.existsByDocumentNumber(teacher.getDocumentNumber()))
            return null;
        return teacherRepository.create(teacher);
    }

    // Metodo Eliminar
    @Override
    public boolean delete(Long teacherId) {
        if (teacherId == null)
            return false;
        return teacherRepository.delete(teacherId);
    }

    // Metodo Actualizar
    @Override
    public boolean update(Teacher teacherUpdate) {
        if (teacherUpdate == null || teacherUpdate.getTeacherId() == null)
            return false;
        if (isInvalidTeacher(teacherUpdate))
            return false;
        return teacherRepository.update(teacherUpdate);
    }

    // Metodo buscar por ID
    @Override
    public Teacher findById(Long teacherId) {
        if (teacherId == null)
            return null;
        return teacherRepository.findById(teacherId);
    }

    // Metodo buscar todos
    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    // Metodo verificar si existe por documento
    @Override
    public boolean existsByDocumentNumber(String documentNumber) {
        if (isBlank(documentNumber))
            return false;
        return teacherRepository.existsByDocumentNumber(documentNumber);
    }

    // Metodo buscar por documento
    @Override
    public Teacher findByDocumentNumber(String documentNumber) {
        if (isBlank(documentNumber))
            return null;
        return teacherRepository.findByDocumentNumber(documentNumber);
    }

    // Metodo contar
    @Override
    public int count() {
        return teacherRepository.count();
    }

    // Verifica si un Teacher es inválido
    private boolean isInvalidTeacher(Teacher teacher) {
        return teacher == null
                || isBlank(teacher.getDocumentNumber())
                || isBlank(teacher.getFirstName())
                || isBlank(teacher.getLastName())
                || teacher.getStatus() == null
                || teacher.getDocumentNumber().length() < 5
                || teacher.getFirstName().length() < 2
                || teacher.getLastName().length() < 2;
    }

    // Verifica si un String es nulo o está en blanco
    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}