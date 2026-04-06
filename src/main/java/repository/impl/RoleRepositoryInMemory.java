package repository.impl;

import co.edu.cesde.g.models.Role;
import repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;

/*Esta clase cumple el contrato de la interfaz RoleRepository.
El implements obliga a tener todos los métodos definidos en la interfaz.*/
public class RoleRepositoryInMemory implements RoleRepository {

    private final List<Role> roles;
    private Long nextRoleId;

    public RoleRepositoryInMemory() {
        this.roles = new ArrayList<>();
        this.nextRoleId = 1L;
    }

    // Metodo crear Rol
    @Override
    public Role create(Role role) {
        if (role == null) {
            return null;
        }
        if (existsByName(role.getName())) {
            return null;
        }
        role.setRoleId(nextRoleId++);
        roles.add(role);
        return role;
    }

    // Metodo eliminar Rol
    @Override
    public boolean delete(Long roleId) {
        Role role = findById(roleId);
        if (role == null) {
            return false;
        }
        return roles.remove(role);
    }

    // Metodo actualizar Rol
    @Override
    public boolean update(Role roleupdate) {
        if (roleupdate == null || roleupdate.getRoleId() == null) {
            return false;
        }
        for (Role role : roles) {
            if (!role.getRoleId().equals(roleupdate.getRoleId())
                    && role.getName().equals(roleupdate.getName())) {
                return false;
            }
        }
        for (int i = 0; i < roles.size(); i++) {
            if (roles.get(i).getRoleId().equals(roleupdate.getRoleId())) {
                roles.set(i, roleupdate);
                return true;
            }
        }
        return false;
    }

    // Metodo buscar por Id
    @Override
    public Role findById(Long roleId) {
        if (roleId == null) {
            return null;
        }
        for (Role role : roles) {
            if (roleId.equals(role.getRoleId())) {
                return role;
            }
        }
        return null;
    }

    // Metodo buscar todos
    @Override
    public List<Role> findAll() {
        return new ArrayList<>(roles);
    }

    // Metodo verificar si existe por nombre
    @Override
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }

    // Metodo buscar por nombre
    @Override
    public Role findByName(String name) {
        if (name == null || name.isBlank()) {
            return null;
        }
        for (Role role : roles) {
            if (name.equals(role.getName())) {
                return role;
            }
        }
        return null;
    }

    // Metodo contar roles
    @Override
    public int count() {
        return roles.size();
    }
}