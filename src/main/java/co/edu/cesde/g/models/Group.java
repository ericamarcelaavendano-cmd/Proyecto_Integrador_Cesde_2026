package co.edu.cesde.g.models;

public class Group {
    private Long groupId;
    private String code;
    private Long programId;
    private Long periodId;
    private String shift;

    public Group() {
    }

    public Group(Long groupId, String code, Long programId, Long periodId, String shift) {
        this.groupId = groupId;
        this.code = code;
        this.programId = programId;
        this.periodId = periodId;
        this.shift = shift;
    }

    public Long getGroupId() {
        return groupId;
    }

    public String getCode() {
        return code;
    }

    public Long getProgramId() {
        return programId;
    }

    public Long getPeriodId() {
        return periodId;
    }

    public String getShift() {
        return shift;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
    @Override
    public String toString() {
        return "Group {groupId=" + groupId +
                ", code='" + code +
                "', programId=" + programId +
                ", periodId=" + periodId +
                ", shift='" + shift +
                "'}";
    }
}
