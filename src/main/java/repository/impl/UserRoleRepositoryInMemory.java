package repository.impl;

import co.edu.cesde.g.models.UserRole;
import repository.UserRoleRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRoleRepositoryInMemory implements UserRoleRepository {

    private final List<UserRole> userRoles;

    public UserRoleRepositoryInMemory() {
        this.userRoles = new ArrayList<>();
    }

    // Metodo crear
    @Override
    public UserRole create(UserRole userRole) {
        if (userRole == null) {
            return null;
        }
        if (existsByUserIdAndRoleId(userRole.getUserId(), userRole.getRoleId())) {
            return null;
        }
        userRoles.add(userRole);
        return userRole;
    }

    // Metodo eliminar
    @Override
    public boolean delete(Long userId, Long roleId) {
        if (userId == null || roleId == null) {
            return false;
        }
        /* En este metodo se necesita el for porque no tiene IDpropio
         para buscar directamente UserRole solo tiene UserId y RoleId, entonces para eliminar una
         relacion necesita recorrer toda la lista buscando la convinacion exacta de UserId y RoleId*/

        for (UserRole userRole : userRoles) {
            if (userRole.getUserId().equals(userId) && userRole.getRoleId().equals(roleId)) {
                return userRoles.remove(userRole);
            }
        }
        return false;
    }

    // Metodo buscar por userId
    @Override
    public List<UserRole> findByUserId(Long userId) {
        List<UserRole> result = new ArrayList<>();
        if (userId == null) {
            return result;
        }
        /* El metodo findByUserId funciona parecido, también recorre
         la lista uno por uno, pero la diferencia
        es que no busca una combinación exacta sino que busca todos los registros que tengan ese userId.
         Por ejemplo si un usuario tiene 3 roles, el for los va encontrando uno a uno y los va agregando a una lista nueva.
         Al final retorna esa lista con todos los roles que tiene ese usuario.*/
        for (UserRole userRole : userRoles) {
            if (userId.equals(userRole.getUserId())) {
                result.add(userRole);
            }
        }
        return result;
    }

    // Metodo buscar por roleId
    @Override
    public List<UserRole> findByRoleId(Long roleId) {
        List<UserRole> result = new ArrayList<>();
        if (roleId == null) {
            return result;
        }
        /*El metodo findByRoleId funciona exactamente igual que findByUserId pero al revés.
          En lugar de buscar todos los roles de un usuario, busca todos los usuarios que tienen un rol específico.
         Recorre la lista uno por uno y va buscando todos los registros que tengan ese roleId. */
        for (UserRole userRole : userRoles) {
            if (roleId.equals(userRole.getRoleId())) {
                result.add(userRole);
            }
        }
        return result;
    }

    // Metodo verificar si existe la relacion
    @Override
    public boolean existsByUserIdAndRoleId(Long userId, Long roleId) {
        if (userId == null || roleId == null) {
            return false;
        }
        /*Recorre la lista uno por uno buscando un registro que tenga exactamente el mismo userId Y el mismo roleId.
        Si lo encuentra retorna true significando que esa relación ya existe.
        Si recorre toda la lista y no lo encuentra retorna false significando que esa relación no existe todavía.*/
        for (UserRole userRole : userRoles) {
            if (userRole.getUserId().equals(userId) && userRole.getRoleId().equals(roleId)) {
                return true;
            }
        }
        return false;
    }

    // Metodo contar
    @Override
    public int count() {
        return userRoles.size();
    }
}
