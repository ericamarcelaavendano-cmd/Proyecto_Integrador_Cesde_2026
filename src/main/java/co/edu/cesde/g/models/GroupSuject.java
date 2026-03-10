package co.edu.cesde.g.models;

public class GroupSuject {
    private Long groupSubjectId;
    private Long groupId;
    private Long subjectId;
    private Long teacherId;

    public GroupSuject() {
    }

    public GroupSuject(Long groupSubject, Long groupId, Long subjectId, Long teacherId) {
        this.groupSubjectId = groupSubject;
        this.groupId = groupId;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
    }

    public Long getGroupSubjectId() {
        return groupSubjectId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setGroupSubjectId(Long groupSubjectId) {
        this.groupSubjectId = groupSubjectId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
    @Override
    public String toString() {
        return "GroupSubject{" +
                "groupSubjectId=" + groupSubjectId +
                ", groupId=" + groupId +
                ", subjectId=" + subjectId +
                ", teacherId=" + teacherId +
                '}';
    }

}
