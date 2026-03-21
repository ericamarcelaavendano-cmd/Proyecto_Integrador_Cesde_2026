package repository.impl;

import co.edu.cesde.g.models.Student;
import repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryInMemory implements StudentRepository {

    private List<Student> students;
    private long nexStudentId;
//Constructor vacio
    public StudentRepositoryInMemory() {
        this.students = new ArrayList<>();
        this.nexStudentId = 1L;
    }

    @Override
    public Student create(Student student) {
        if (student == null) {
            return null;
        }

        if (finByDocumentNumber(student.getDocumentNumber())) {
            return null;
        }

        students.add(student);
        return student;


    }


    @Override
    public boolean delete(long studentId) {
        return false;
    }

    @Override
    public boolean update(Student studentupdate) {
        return false;
    }

    @Override
    public boolean finById(long studentId) {
        return false;
    }


    @Override
    public boolean finByDocumentNumber(String documentNumber) {
        return false;
    }

    @Override
    public List<Student> findAll() {
        return List.of();
    }

    @Override
    public boolean existById(long studentId) {
        return false;
    }
}
