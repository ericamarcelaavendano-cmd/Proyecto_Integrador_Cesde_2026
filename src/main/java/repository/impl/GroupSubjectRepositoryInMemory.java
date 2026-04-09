package repository.impl;

import co.edu.cesde.g.models.GroupSubject;
import repository.GroupSubjectRepository;

import java.util.ArrayList;
import java.util.List;

public class GroupSubjectRepositoryInMemory implements GroupSubjectRepository {

    private final List<GroupSubject> groupSubjects;
    private Long nextGroupSubjectId;

    public GroupSubjectRepositoryInMemory() {
        this.groupSubjects = new ArrayList<>();
        this.nextGroupSubjectId = 1L;
    }

    // Metodo Crear
    @Override
    public GroupSubject create(GroupSubject groupSubject) {
        if (groupSubject == null)
            return null;
        if (existsByGroupIdAndSubjectId(groupSubject.getGroupId(), groupSubject.getSubjectId()))
            return null;
        groupSubject.setGroupSubjectId(nextGroupSubjectId++);
        groupSubjects.add(groupSubject);
        return groupSubject;
    }

    // Metodo Eliminar
    @Override
    public boolean delete(Long groupSubjectId) {
        GroupSubject groupSubject = findById(groupSubjectId);
        if (groupSubject == null)
            return false;
        return groupSubjects.remove(groupSubject);
    }

    // Metodo Actualizar
    @Override
    public boolean update(GroupSubject groupSubjectUpdate) {
        if (groupSubjectUpdate == null || groupSubjectUpdate.getGroupSubjectId() == null)
            return false;
        for (int i = 0; i < groupSubjects.size(); i++) {
            if (groupSubjects.get(i).getGroupSubjectId().equals(groupSubjectUpdate.getGroupSubjectId())) {
                groupSubjects.set(i, groupSubjectUpdate);
                return true;
            }
        }
        return false;
    }

    // Metodo buscar por ID
    @Override
    public GroupSubject findById(Long groupSubjectId) {
        if (groupSubjectId == null)
            return null;
        for (GroupSubject groupSubject : groupSubjects) {
            if (groupSubject.getGroupSubjectId().equals(groupSubjectId)) {
                return groupSubject;
            }
        }
        return null;
    }

    // Metodo buscar todos
    @Override
    public List<GroupSubject> findAll() {
        return new ArrayList<>(groupSubjects);
    }

    // Metodo buscar por groupId
    @Override
    public List<GroupSubject> findByGroupId(Long groupId) {
        List<GroupSubject> result = new ArrayList<>();
        if (groupId == null)
            return result;
        for (GroupSubject groupSubject : groupSubjects) {
            if (groupId.equals(groupSubject.getGroupId())) {
                result.add(groupSubject);
            }
        }
        return result;
    }

    // Metodo buscar por subjectId
    @Override
    public List<GroupSubject> findBySubjectId(Long subjectId) {
        List<GroupSubject> result = new ArrayList<>();
        if (subjectId == null)
            return result;
        for (GroupSubject groupSubject : groupSubjects) {
            if (subjectId.equals(groupSubject.getSubjectId())) {
                result.add(groupSubject);
            }
        }
        return result;
    }

    // Metodo buscar por teacherId
    @Override
    public List<GroupSubject> findByTeacherId(Long teacherId) {
        List<GroupSubject> result = new ArrayList<>();
        if (teacherId == null)
            return result;
        for (GroupSubject groupSubject : groupSubjects) {
            if (teacherId.equals(groupSubject.getTeacherId())) {
                result.add(groupSubject);
            }
        }
        return result;
    }

    // Metodo verificar si existe la combinación group-subject
    @Override
    public boolean existsByGroupIdAndSubjectId(Long groupId, Long subjectId) {
        if (groupId == null || subjectId == null)
            return false;
        for (GroupSubject groupSubject : groupSubjects) {
            if (groupId.equals(groupSubject.getGroupId()) &&
                    subjectId.equals(groupSubject.getSubjectId())) {
                return true;
            }
        }
        return false;
    }

    // Metodo contar
    @Override
    public int count() {
        return groupSubjects.size();
    }
}