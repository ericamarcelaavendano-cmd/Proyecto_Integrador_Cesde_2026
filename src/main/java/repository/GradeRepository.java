package repository;

import co.edu.cesde.g.models.Grade;

import java.util.List;

public interface GradeRepository {

    Grade create(Grade grade);

    boolean delete(Long gradeId);

    boolean update(Grade gradeUpdate);

    Grade findById(Long gradeId);

    List<Grade> findAll();

    List<Grade> findByStudentId(Long studentId);

    List<Grade> findByGroupSubjectId(Long groupSubjectId);

    boolean existsByStudentIdAndGroupSubjectId(Long studentId, Long groupSubjectId);

    int count();
}