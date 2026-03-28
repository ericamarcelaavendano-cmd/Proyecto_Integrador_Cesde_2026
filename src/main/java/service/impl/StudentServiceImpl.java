package service.impl;

import co.edu.cesde.g.models.Student;
import repository.StudentRepository;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(Student student) {
        if (isInvalidStudent(student) || studentRepository.existsByDocumentNumber(student.getDocumentNumber()))
            return null;

        return studentRepository.create(student);
    }

    @Override
    public boolean delete(Long studentId) {
        if (studentId == null)
            return false;

        return studentRepository.delete(studentId);
    }

    @Override
    public boolean update(Student studentUpdate) {
        if (isInvalidStudent(studentUpdate) || studentUpdate.getStudentId() == null)
            return false;

        return studentRepository.update(studentUpdate);
    }

    @Override
    public Student findById(Long studentId) {
        if (studentId == null)
            return null;

        return studentRepository.findById(studentId);
    }

    @Override
    public Student findByDocumentNumber(String documentNumber) {
        if (isBlank(documentNumber))
            return null;

        return studentRepository.findByDocumentNumber(documentNumber);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public boolean existsByDocumentNumber(String documentNumber) {
        if (isBlank(documentNumber))  //Valida que el documento no esté vacío
            return false;

        return studentRepository.existsByDocumentNumber(documentNumber);
    }

    @Override
    public int count() {
        return studentRepository.count();
    }

    // si está en blanco es inválido.
    private boolean isInvalidStudent(Student student) {
        return student == null
                || isBlank(student.getCode())
                || isBlank(student.getDocumentNumber())
                || isBlank(student.getFirstName())
                || isBlank(student.getLastName())
                || isBlank(student.getBirthDate())
                || student.getStatus() == null;
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}