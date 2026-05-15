package service.impl;

import co.edu.cesde.g.models.UserRole;
import repository.UserRoleRepository;
import service.UserRoleService;

import java.util.ArrayList;
import java.util.List;

public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole create(UserRole userRole) {
        if (isInvalidUserRole(userRole))
            return null;
        if (existsByUserIdAndRoleId(userRole.getUserId(), userRole.getRoleId()))
            return null;
        return userRoleRepository.create(userRole);
    }

    @Override
    public boolean delete(Long userId, Long roleId) {
        if (userId == null || roleId == null)
            return false;
        return userRoleRepository.delete(userId, roleId);
    }

    @Override
    public List<UserRole> findByUserId(Long userId) {
        if (userId == null)
            return new ArrayList<>();
        return userRoleRepository.findByUserId(userId);
    }

    @Override
    public List<UserRole> findByRoleId(Long roleId) {
        if (roleId == null)
            return new ArrayList<>();
        return userRoleRepository.findByRoleId(roleId);
    }

    @Override
    public boolean existsByUserIdAndRoleId(Long userId, Long roleId) {
        if (userId == null || roleId == null)
            return false;
        return userRoleRepository.existsByUserIdAndRoleId(userId, roleId);
    }

    @Override
    public int count() {
        return userRoleRepository.count();
    }

    // Verifica si un UserRole es inválido
    private boolean isInvalidUserRole(UserRole userRole) {
        return userRole == null
                || userRole.getUserId() == null
                || userRole.getRoleId() == null;
    }
}