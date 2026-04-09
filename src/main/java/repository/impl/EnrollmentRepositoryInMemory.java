package repository.impl;

import co.edu.cesde.g.models.Enrollment;
import repository.EnrollmentRepository;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepositoryInMemory implements EnrollmentRepository {

    private final List<Enrollment> enrollments;
    private Long nextEnrollmentId;

    public EnrollmentRepositoryInMemory() {
        this.enrollments = new ArrayList<>();
        this.nextEnrollmentId = 1L;
    }

    @Override
    public Enrollment create(Enrollment enrollment) {
        if (enrollment == null)
            return null;
        if (existsByStudentIdAndGroupId(enrollment.getStudentId(), enrollment.getGroupId()))
            return null;
        enrollment.setEnrollmentId(nextEnrollmentId++);
        enrollments.add(enrollment);return enrollment;
    }

    @Override
    public boolean delete(Long enrollmentId) {
        Enrollment enrollment = findById(enrollmentId);
        if (enrollment == null)
            return false;
        return enrollments.remove(enrollment);
    }

    @Override
    public boolean update(Enrollment enrollmentUpdate) {
        if (enrollmentUpdate == null || enrollmentUpdate.getEnrollmentId() == null)
            return false;
        for (int i = 0; i < enrollments.size(); i++) {
            if (enrollments.get(i).getEnrollmentId().equals(enrollmentUpdate.getEnrollmentId())) {
                enrollments.set(i, enrollmentUpdate);
                return true;
            }
        }
        return false;
    }

    @Override
    public Enrollment findById(Long enrollmentId) {
        if (enrollmentId == null)
            return null;
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getEnrollmentId().equals(enrollmentId)) {
                return enrollment;
            }
        }
        return null;
    }

    @Override
    public List<Enrollment> findAll() {
        return new ArrayList<>(enrollments);
    }

    @Override
    public List<Enrollment> findByStudentId(Long studentId) {
        List<Enrollment> result = new ArrayList<>();
        if (studentId == null)
            return result;
        for (Enrollment enrollment : enrollments) {
            if (studentId.equals(enrollment.getStudentId())) {
                result.add(enrollment);
            }
        }
        return result;
    }

    @Override
    public List<Enrollment> findByGroupId(Long groupId) {
        List<Enrollment> result = new ArrayList<>();
        if (groupId == null)
            return result;
        for (Enrollment enrollment : enrollments) {
            if (groupId.equals(enrollment.getGroupId())) {
                result.add(enrollment);
            }
        }
        return result;
    }

    @Override
    public List<Enrollment> findByPeriodId(Long periodId) {
        List<Enrollment> result = new ArrayList<>();
        if (periodId == null)
            return result;
        for (Enrollment enrollment : enrollments) {
            if (periodId.equals(enrollment.getPeriodId())) {
                result.add(enrollment);
            }
        }
        return result;
    }

    @Override
    public boolean existsByStudentIdAndGroupId(Long studentId, Long groupId) {
        if (studentId == null || groupId == null)
            return false;
        for (Enrollment enrollment : enrollments) {
            if (studentId.equals(enrollment.getStudentId()) &&
                    groupId.equals(enrollment.getGroupId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int count() {
        return enrollments.size();
    }
}
