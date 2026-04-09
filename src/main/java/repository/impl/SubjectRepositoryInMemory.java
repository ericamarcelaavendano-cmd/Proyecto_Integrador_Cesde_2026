package repository.impl;

import co.edu.cesde.g.models.Subject;
import repository.SubjectRepository;

import java.util.ArrayList;
import java.util.List;

public class SubjectRepositoryInMemory implements SubjectRepository {

    private final List<Subject> subjects;
    private Long nextSubjectId;

    public SubjectRepositoryInMemory() {
        this.subjects = new ArrayList<>();
        this.nextSubjectId = 1L;
    }

    // Metodo Crear
    @Override
    public Subject create(Subject subject) {
        if (subject == null)
            return null;
        if (existsByCode(subject.getCode()))
            return null;
        subject.setSubjectId(nextSubjectId++);
        subjects.add(subject);
        return subject;
    }

    // Metodo Eliminar
    @Override
    public boolean delete(Long subjectId) {
        Subject subject = findById(subjectId);
        if (subject == null)
            return false;
        return subjects.remove(subject);
    }

    // Metodo Actualizar
    @Override
    public boolean update(Subject subjectUpdate) {
        if (subjectUpdate == null || subjectUpdate.getSubjectId() == null)
            return false;
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getSubjectId().equals(subjectUpdate.getSubjectId())) {
                subjects.set(i, subjectUpdate);
                return true;
            }
        }
        return false;
    }

    // Metodo buscar por ID
    @Override
    public Subject findById(Long subjectId) {
        if (subjectId == null)
            return null;
        for (Subject subject : subjects) {
            if (subject.getSubjectId().equals(subjectId)) {
                return subject;
            }
        }
        return null;
    }

    // Metodo buscar todos
    @Override
    public List<Subject> findAll() {
        return new ArrayList<>(subjects);
    }

    // Metodo verificar si existe por código
    @Override
    public boolean existsByCode(String code) {
        return findByCode(code) != null;
    }

    // Metodo buscar por código
    @Override
    public Subject findByCode(String code) {
        if (code == null || code.isBlank())
            return null;
        for (Subject subject : subjects) {
            if (code.equalsIgnoreCase(subject.getCode())) {
                return subject;
            }
        }
        return null;
    }

    // Metodo buscar por programId
    @Override
    public List<Subject> findByProgramId(Long programId) {
        List<Subject> result = new ArrayList<>();
        if (programId == null)
            return result;
        for (Subject subject : subjects) {
            if (programId.equals(subject.getProgramId())) {
                result.add(subject);
            }
        }
        return result;
    }

    // Metodo contar
    @Override
    public int count() {
        return subjects.size();
    }
}