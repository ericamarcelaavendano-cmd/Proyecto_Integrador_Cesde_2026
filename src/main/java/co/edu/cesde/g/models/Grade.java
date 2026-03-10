package co.edu.cesde.g.models;

public class Grade {
    private Long gradeId;
    private Long groupSubjectId;
    private Long studentId;
    private Integer finalScore;
    private String observation;

    public Grade() {
    }

    public Grade(Long gradeId, Long groupSubjectId, Long studentId, Integer finalScore, String observation) {
        this.gradeId = gradeId;
        this.groupSubjectId = groupSubjectId;
        this.studentId = studentId;
        this.finalScore = finalScore;
        this.observation = observation;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public Long getGroupSubjectId() {
        return groupSubjectId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Integer getFinalScore() {
        return finalScore;
    }

    public String getObservation() {
        return observation;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public void setGroupSubjectId(Long groupSubjectId) {
        this.groupSubjectId = groupSubjectId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setFinalScore(Integer finalScore) {
        this.finalScore = finalScore;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
    @Override
    public String toString() {
        return "Grade{" +
                "gradeId=" + gradeId +
                ", groupSubjectId=" + groupSubjectId +
                ", studentId=" + studentId +
                ", finalScore=" + finalScore +
                ", observation='" + observation +
                '}';
    }
}

