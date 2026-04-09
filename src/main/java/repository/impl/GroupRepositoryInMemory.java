package repository.impl;

import co.edu.cesde.g.models.Group;
import repository.GroupRepository;

import java.util.ArrayList;
import java.util.List;

public class GroupRepositoryInMemory implements GroupRepository {

    private final List<Group> groups;
    private Long nextGroupId;

    public GroupRepositoryInMemory() {
        this.groups = new ArrayList<>();
        this.nextGroupId = 1L;
    }

    // Metodo Crear
    @Override
    public Group create(Group group) {
        if (group == null)
            return null;
        if (existsByCode(group.getCode()))
            return null;
        group.setGroupId(nextGroupId++);
        groups.add(group);
        return group;
    }

    // Metodo Eliminar
    @Override
    public boolean delete(Long groupId) {
        Group group = findById(groupId);
        if (group == null)
            return false;
        return groups.remove(group);
    }

    // Metodo Actualizar
    @Override
    public boolean update(Group groupUpdate) {
        if (groupUpdate == null || groupUpdate.getGroupId() == null)
            return false;
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getGroupId().equals(groupUpdate.getGroupId())) {
                groups.set(i, groupUpdate);
                return true;
            }
        }
        return false;
    }

    // Metodo buscar por código
    @Override
    public Group findByCode(String code) {
        if (code == null || code.isBlank())
            return null;
        for (Group group : groups) {
            if (code.equalsIgnoreCase(group.getCode())) {
                return group;
            }
        }
        return null;
    }

    // Metodo buscar por ID
    @Override
    public Group findById(Long groupId) {
        if (groupId == null)
            return null;
        for (Group group : groups) {
            if (group.getGroupId().equals(groupId)) {
                return group;
            }
        }
        return null;
    }

    // Metodo buscar por periodId
    @Override
    public List<Group> findByPeriodId(Long periodId) {
        List<Group> result = new ArrayList<>();
        if (periodId == null)
            return result;
        for (Group group : groups) {
            if (periodId.equals(group.getPeriodId())) {
                result.add(group);
            }
        }
        return result;
    }

    // Metodo buscar todos
    @Override
    public List<Group> findAll() {
        return new ArrayList<>(groups);
    }

    // Metodo verificar si existe por código
    @Override
    public boolean existsByCode(String code) {
        return findByCode(code) != null;
    }

    // Metodo buscar por programId
    @Override
    public List<Group> findByProgramId(Long programId) {
        List<Group> result = new ArrayList<>();
        if (programId == null)
            return null;
        for (Group group : groups) {
            if (programId.equals(group.getProgramId())) {
                result.add(group);
            }
        }
        return result;
    }

    // Metodo contar
    @Override
    public int count() {
        return groups.size();
    }
}