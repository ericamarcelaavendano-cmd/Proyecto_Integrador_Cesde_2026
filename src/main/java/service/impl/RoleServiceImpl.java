package service.impl;

import co.edu.cesde.g.models.Role;
import repository.RoleRepository;
import service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // Metodo crear
    @Override
    public Role create(Role role) {
        if (isInvalidRole(role) || roleRepository.existsByName(role.getName()))
            return null;
        return roleRepository.create(role);
    }

    // Metodo eliminar
    @Override
    public boolean delete(Long roleId) {
        if (roleId == null)
            return false;
        return roleRepository.delete(roleId);
    }

    // Metodo actualizar
    @Override
    public boolean update(Role roleupdate) {
        if (isInvalidRole(roleupdate) || roleupdate.getRoleId() == null)
            return false;
        return roleRepository.update(roleupdate);
    }

    // Metodo buscar por Id
    @Override
    public Role findById(Long roleId) {
        if (roleId == null)
            return null;
        return roleRepository.findById(roleId);
    }

    // Metodo buscar todos
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    // Metodo verificar si existe por nombre
    @Override
    public boolean existsByName(String name) {
        if (isBlank(name))
            return false;
        return roleRepository.existsByName(name);
    }

    // Metodo buscar por nombre
    @Override
    public Role findByName(String name) {
        if (isBlank(name))
            return null;
        return roleRepository.findByName(name);
    }

    // Metodo contar
    @Override
    public int count() {
        return roleRepository.count();
    }

    // Metodo validar si el rol es invalido
    private boolean isInvalidRole(Role role) {
        return role == null
                || role.getRoleId() == null
                || isBlank(role.getName())
                || isBlank(role.getDescription());
    }

    // Metodo validar si el texto esta vacio
    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}

