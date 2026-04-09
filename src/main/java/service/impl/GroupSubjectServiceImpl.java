package service.impl;

import co.edu.cesde.g.models.GroupSubject;
import repository.GroupSubjectRepository;
import service.GroupSubjectService;

import java.util.ArrayList;
import java.util.List;

public class GroupSubjectServiceImpl implements GroupSubjectService {

    private final GroupSubjectRepository groupSubjectRepository;

    public GroupSubjectServiceImpl(GroupSubjectRepository groupSubjectRepository) {
        this.groupSubjectRepository = groupSubjectRepository;
    }

    // Metodo Crear
    @Override
    public GroupSubject create(GroupSubject groupSubject) {
        if (isInvalidGroupSubject(groupSubject) ||
                groupSubjectRepository.existsByGroupIdAndSubjectId(
                        groupSubject.getGroupId(), groupSubject.getSubjectId()))
            return null;
        return groupSubjectRepository.create(groupSubject);
    }

    // Metodo Eliminar
    @Override
    public boolean delete(Long groupSubjectId) {
        if (groupSubjectId == null)
            return false;
        return groupSubjectRepository.delete(groupSubjectId);
    }

    // Metodo Actualizar
    @Override
    public boolean update(GroupSubject groupSubjectUpdate) {
        if (isInvalidGroupSubject(groupSubjectUpdate) ||
                groupSubjectUpdate.getGroupSubjectId() == null)
            return false;
        return groupSubjectRepository.update(groupSubjectUpdate);
    }

    // Metodo buscar por ID
    @Override
    public GroupSubject findById(Long groupSubjectId) {
        if (groupSubjectId == null)
            return null;
        return groupSubjectRepository.findById(groupSubjectId);
    }

    // Metodo buscar todos
    @Override
    public List<GroupSubject> findAll() {
        return groupSubjectRepository.findAll();
    }

    // Metodo buscar por groupId
    @Override
    public List<GroupSubject> findByGroupId(Long groupId) {
        if (groupId == null)
            return new ArrayList<>();
        return groupSubjectRepository.findByGroupId(groupId);
    }

    // Metodo buscar por subjectId
    @Override
    public List<GroupSubject> findBySubjectId(Long subjectId) {
        if (subjectId == null)
            return new ArrayList<>();
        return groupSubjectRepository.findBySubjectId(subjectId);
    }

    // Metodo buscar por teacherId
    @Override
    public List<GroupSubject> findByTeacherId(Long teacherId) {
        if (teacherId == null)
            return new ArrayList<>();
        return groupSubjectRepository.findByTeacherId(teacherId);
    }

    // Metodo verificar si existe la combinación
    @Override
    public boolean existsByGroupIdAndSubjectId(Long groupId, Long subjectId) {
        if (groupId == null || subjectId == null)
            return false;
        return groupSubjectRepository.existsByGroupIdAndSubjectId(groupId, subjectId);
    }

    // Metodo contar
    @Override
    public int count() {
        return groupSubjectRepository.count();
    }

    // Verifica si un GroupSubject es inválido
    private boolean isInvalidGroupSubject(GroupSubject groupSubject) {
        return groupSubject == null
                || groupSubject.getGroupId() == null
                || groupSubject.getSubjectId() == null
                || groupSubject.getTeacherId() == null;
    }
}