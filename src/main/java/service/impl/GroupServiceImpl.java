package service.impl;

import co.edu.cesde.g.models.Group;
import repository.GroupRepository;
import service.GroupService;

import java.util.ArrayList;
import java.util.List;

public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group create(Group group) {
        if (isInvalidGroup(group) || groupRepository.existsByCode(group.getCode()))
            return null;
        return groupRepository.create(group);
    }

    @Override
    public boolean delete(Long groupId) {
        if (groupId == null)
            return false;
        return groupRepository.delete(groupId);
    }

    @Override
    public boolean update(Group groupUpdate) {
        if (isInvalidGroup(groupUpdate) || groupUpdate.getGroupId() == null)
            return false;
        return groupRepository.update(groupUpdate);
    }

    @Override
    public Group findByCode(String code) {
        if (isBlank(code))
            return null;
        return groupRepository.findByCode(code);
    }

    @Override
    public Group findById(Long groupId) {
        if (groupId == null)
            return null;
        return groupRepository.findById(groupId);
    }

    @Override
    public List<Group> findByPeriodId(Long periodId) {
        if (periodId == null)
            return new ArrayList<>();
        return groupRepository.findByPeriodId(periodId);
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public boolean existsByCode(String code) {
        if (isBlank(code))
            return false;
        return groupRepository.existsByCode(code);
    }

    @Override
    public List<Group> findByProgramId(Long programId) {
        if (programId == null)
            return new ArrayList<>();
        return groupRepository.findByProgramId(programId);
    }

    @Override
    public int count() {
        return groupRepository.count();
    }

    // Verifica si un grupo es inválido
    private boolean isInvalidGroup(Group group) {
        return group == null
                || isBlank(group.getCode())
                || group.getProgramId() == null
                || group.getPeriodId() == null
                || isBlank(group.getShift());
    }

    // Verifica si un String es nulo o está en blanco
    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}
