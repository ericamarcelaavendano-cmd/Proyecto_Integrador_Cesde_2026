package service;

import co.edu.cesde.g.models.Enrollment;

import java.util.List;

public interface EnrollmentService {

    Enrollment create(Enrollment enrollment);

    boolean delete(Long enrollmentId);

    boolean update(Enrollment enrollmentUpdate);

    Enrollment findById(Long enrollmentId);

    List<Enrollment> findAll();

    List<Enrollment> findByStudentId(Long studentId);

    List<Enrollment> findByGroupId(Long groupId);

    List<Enrollment> findByPeriodId(Long periodId);

    boolean existsByStudentIdAndGroupId(Long studentId, Long groupId);

    int count();
}
