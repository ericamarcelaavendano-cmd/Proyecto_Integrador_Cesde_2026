package service.impl;

import co.edu.cesde.g.models.Grade;
import repository.GradeRepository;
import service.GradeService;

import java.util.ArrayList;
import java.util.List;

public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;

    public GradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public Grade create(Grade grade) {
        if (isInvalidGrade(grade) ||
                gradeRepository.existsByStudentIdAndGroupSubjectId(
                        grade.getStudentId(), grade.getGroupSubjectId()))
            return null;
        return gradeRepository.create(grade);
    }

    @Override
    public boolean delete(Long gradeId) {
        if (gradeId == null)
            return false;
        return gradeRepository.delete(gradeId);
    }

    @Override
    public boolean update(Grade gradeUpdate) {
        if (isInvalidGrade(gradeUpdate) || gradeUpdate.getGradeId() == null)
            return false;
        return gradeRepository.update(gradeUpdate);
    }

    @Override
    public Grade findById(Long gradeId) {
        if (gradeId == null)
            return null;
        return gradeRepository.findById(gradeId);
    }

    @Override
    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }

    @Override
    public List<Grade> findByStudentId(Long studentId) {
        if (studentId == null)
            return new ArrayList<>();
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public List<Grade> findByGroupSubjectId(Long groupSubjectId) {
        if (groupSubjectId == null)
            return new ArrayList<>();
        return gradeRepository.findByGroupSubjectId(groupSubjectId);
    }

    @Override
    public boolean existsByStudentIdAndGroupSubjectId(Long studentId, Long groupSubjectId) {
        if (studentId == null || groupSubjectId == null)
            return false;
        return gradeRepository.existsByStudentIdAndGroupSubjectId(studentId, groupSubjectId);
    }

    @Override
    public int count() {
        return gradeRepository.count();
    }

    private boolean isInvalidGrade(Grade grade) {
        return grade == null
                || grade.getStudentId() == null
                || grade.getGroupSubjectId() == null
                || grade.getFinalScore() == null;
    }
}
