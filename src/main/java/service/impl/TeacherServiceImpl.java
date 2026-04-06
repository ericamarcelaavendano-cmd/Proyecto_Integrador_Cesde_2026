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

    @Override
    public Teacher create(Teacher teacher) {
        if (isInvalidTeacher(teacher) || teacherRepository.existsByDocumentNumber(teacher.getDocumentNumber()))
            return null;
        return teacherRepository.create(teacher);
    }

    @Override
    public boolean delete(Long teacherId) {
        if (teacherId == null)
            return false;
        return teacherRepository.delete(teacherId);
    }

    @Override
    public boolean update(Teacher teacherUpdate) {
        if (isInvalidTeacher(teacherUpdate) || teacherUpdate.getTeacherId() == null)
            return false;

        return teacherRepository.update(teacherUpdate);
    }

    @Override
    public Teacher findById(Long teacherId) {
        if (teacherId == null)
            return null;
        return teacherRepository.findById(teacherId);
    }

    @Override
    public List<Teacher> findAll() {
        return List.of();
    }

    @Override
    public boolean existsByDocumentNumber(String documentNumber) {
        if (isBlank(documentNumber))
            return false;
        return teacherRepository.existsByDocumentNumber(documentNumber);
    }

    @Override
    public Teacher findByDocumentNumber(String documentNumber) {
        if (isBlank(documentNumber))
            return null;
        return teacherRepository.findByDocumentNumber(documentNumber);

    }

    @Override
    public int count() {
        return 0;
    }

    // si está en blanco es inválido.
    private boolean isInvalidTeacher(Teacher teacher) {
        return teacher == null
                || isBlank(teacher.getCode())
                || isBlank(teacher.getDocumentNumber())
                || isBlank(teacher.getFirstName())
                || isBlank(teacher.getLastName())
                || teacher.getStatus() == null;
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }


}
