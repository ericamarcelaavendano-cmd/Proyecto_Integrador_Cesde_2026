package co.edu.cesde.g.models;

public class Subject {
    private Long subjectId;
    private String code;
    private String name;
    private Integer credits;
    private Long programId;

    public Subject() {
    }

    public Subject(Long subjectId, String code, String name, Integer credits, Long programId) {
        this.subjectId = subjectId;
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.programId = programId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Integer getCredits() {
        return credits;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }
    @Override
    public String toString() {
        return "Subject {subjectId=" + subjectId +
                ", code='" + code +
                "', name='" + name +
                "', credits=" + credits +
                ", programId=" + programId +
                "}";
    }
}
