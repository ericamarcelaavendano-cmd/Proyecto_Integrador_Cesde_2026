package service.impl;

import co.edu.cesde.g.models.Enrollment;
import repository.EnrollmentRepository;
import service.EnrollmentService;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public Enrollment create(Enrollment enrollment) {
        if (isInvalidEnrollment(enrollment) ||
                enrollmentRepository.existsByStudentIdAndGroupId(
                        enrollment.getStudentId(), enrollment.getGroupId()))
            return null;
        return enrollmentRepository.create(enrollment);
    }

    @Override
    public boolean delete(Long enrollmentId) {
        if (enrollmentId == null)
            return false;
        return enrollmentRepository.delete(enrollmentId);
    }

    @Override
    public boolean update(Enrollment enrollmentUpdate) {
        if (isInvalidEnrollment(enrollmentUpdate) || enrollmentUpdate.getEnrollmentId() == null)
            return false;
        return enrollmentRepository.update(enrollmentUpdate);
    }

    @Override
    public Enrollment findById(Long enrollmentId) {
        if (enrollmentId == null)
            return null;
        return enrollmentRepository.findById(enrollmentId);
    }

    @Override
    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    @Override
    public List<Enrollment> findByStudentId(Long studentId) {
        if (studentId == null)
            return new ArrayList<>();
        return enrollmentRepository.findByStudentId(studentId);
    }

    @Override
    public List<Enrollment> findByGroupId(Long groupId) {
        if (groupId == null)
            return new ArrayList<>();
        return enrollmentRepository.findByGroupId(groupId);
    }

    @Override
    public List<Enrollment> findByPeriodId(Long periodId) {
        if (periodId == null)
            return new ArrayList<>();
        return enrollmentRepository.findByPeriodId(periodId);
    }

    @Override
    public boolean existsByStudentIdAndGroupId(Long studentId, Long groupId) {
        if (studentId == null || groupId == null)
            return false;
        return enrollmentRepository.existsByStudentIdAndGroupId(studentId, groupId);
    }

    @Override
    public int count() {
        return enrollmentRepository.count();
    }

    private boolean isInvalidEnrollment(Enrollment enrollment) {
        return enrollment == null
                || enrollment.getStudentId() == null
                || enrollment.getGroupId() == null
                || enrollment.getPeriodId() == null
                || enrollment.getStatus() == null;
    }
}
