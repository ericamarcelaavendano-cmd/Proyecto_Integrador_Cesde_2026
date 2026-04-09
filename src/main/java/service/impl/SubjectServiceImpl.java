package service.impl;

import co.edu.cesde.g.models.Subject;
import repository.SubjectRepository;
import service.SubjectService;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject create(Subject subject) {
        if (isInvalidSubject(subject) || subjectRepository.existsByCode(subject.getCode()))
            return null;
        return subjectRepository.create(subject);

    }

    @Override
    public boolean delete(Long subjectId) {
        if (subjectId == null)
            return false;
        return subjectRepository.delete(subjectId);
    }

    @Override
    public boolean update(Subject subjectUpdate) {
        if (isInvalidSubject(subjectUpdate) || subjectUpdate.getSubjectId() == null)
            return false;
        return subjectRepository.update(subjectUpdate);
    }

    @Override
    public Subject findById(Long subjectId) {
        if (subjectId == null)
            return null;
        return subjectRepository.findById(subjectId);
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public boolean existsByCode(String code) {
        if (isBlank(code))
            return false;
        return subjectRepository.existsByCode(code);
    }

    @Override
    public Subject findByCode(String code) {
        if (isBlank(code))
            return null;
        return subjectRepository.findByCode(code);
    }

    @Override
    public List<Subject> findByProgramId(Long programId) {
        return subjectRepository.findByProgramId(programId);
    }

    @Override
    public int count() {
        return subjectRepository.count();
    }

    private boolean isInvalidSubject(Subject subject) {
        return subject == null
                || isBlank(subject.getCode())
                || isBlank(subject.getName())
                || subject.getCredits() == null
                || subject.getProgramId() == null;
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}
