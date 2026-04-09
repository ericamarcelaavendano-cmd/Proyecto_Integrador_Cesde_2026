package co.edu.cesde.g.models;

import java.time.LocalDateTime;

public class Enrollment {
    private Long enrollmentId;
    private Long studentId;
    private Long groupId;
    private Long periodId;
    private Boolean status;
    private LocalDateTime enrolledAt;

    public Enrollment() {
    }

    public Enrollment(Long enrollmentId, Long studentId, Long groupId, Long periodId, Boolean status, LocalDateTime enrolledAt) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.groupId = groupId;
        this.periodId = periodId;
        this.status = status;
        this.enrolledAt = enrolledAt;
    }

    public Long getEnrollmentId() {
        return enrollmentId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public Long getPeriodId() {
        return periodId;
    }

    public Boolean getStatus() {
        return status;
    }

    public LocalDateTime getEnrolledAt() {
        return enrolledAt;
    }

    public void setEnrollmentId(Long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setEnrolledAt(LocalDateTime enrolledAt) {
        this.enrolledAt = enrolledAt;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "enrollmentId=" + enrollmentId +
                ", studentId=" + studentId +
                ", groupId=" + groupId +
                ", periodId=" + periodId +
                ", status=" + status +
                ", enrolledAt=" + enrolledAt +
                '}';
    }
}