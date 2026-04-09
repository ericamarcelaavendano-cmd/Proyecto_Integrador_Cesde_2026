package repository.impl;

import co.edu.cesde.g.models.Grade;
import repository.GradeRepository;

import java.util.ArrayList;
import java.util.List;

public class GradeRepositoryInMemory implements GradeRepository {

    private final List<Grade> grades;
    private Long nextGradeId;

    public GradeRepositoryInMemory() {
        this.grades = new ArrayList<>();
        this.nextGradeId = 1L;
    }

    @Override
    public Grade create(Grade grade) {
        if (grade == null)
            return null;
        if (existsByStudentIdAndGroupSubjectId(grade.getStudentId(), grade.getGroupSubjectId()))
            return null;
        grade.setGradeId(nextGradeId++);
        grades.add(grade);
        return grade;
    }

    @Override
    public boolean delete(Long gradeId) {
        Grade grade = findById(gradeId);
        if (grade == null)
            return false;
        return grades.remove(grade);
    }

    @Override
    public boolean update(Grade gradeUpdate) {
        if (gradeUpdate == null || gradeUpdate.getGradeId() == null)
            return false;
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i).getGradeId().equals(gradeUpdate.getGradeId())) {
                grades.set(i, gradeUpdate);
                return true;
            }
        }
        return false;
    }

    @Override
    public Grade findById(Long gradeId) {
        if (gradeId == null)
            return null;
        for (Grade grade : grades) {
            if (grade.getGradeId().equals(gradeId)) {
                return grade;
            }
        }
        return null;
    }

    @Override
    public List<Grade> findAll() {
        return new ArrayList<>(grades);
    }

    @Override
    public List<Grade> findByStudentId(Long studentId) {
        List<Grade> result = new ArrayList<>();
        if (studentId == null)
            return result;
        for (Grade grade : grades) {
            if (studentId.equals(grade.getStudentId())) {
                result.add(grade);
            }
        }
        return result;
    }

    @Override
    public List<Grade> findByGroupSubjectId(Long groupSubjectId) {
        List<Grade> result = new ArrayList<>();
        if (groupSubjectId == null)
            return result;
        for (Grade grade : grades) {
            if (groupSubjectId.equals(grade.getGroupSubjectId())) {
                result.add(grade);
            }
        }
        return result;
    }

    @Override
    public boolean existsByStudentIdAndGroupSubjectId(Long studentId, Long groupSubjectId) {
        if (studentId == null || groupSubjectId == null)
            return false;
        for (Grade grade : grades) {
            if (studentId.equals(grade.getStudentId()) &&
                    groupSubjectId.equals(grade.getGroupSubjectId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int count() {
        return grades.size();
    }
}