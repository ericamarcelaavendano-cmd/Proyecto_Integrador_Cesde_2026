package repository;

import co.edu.cesde.g.models.UserRole;
import java.util.List;

public interface UserRoleRepository {
/*Nota importante en este Repository no es necesario el update porque  porque si queremos
cambiar el rol de un usuario simplemente eliminas la relación y creas una nueva.*/

    // Crear la relación usuario-rol
    UserRole create(UserRole userRole);

    // Eliminar la relación
    boolean delete(Long userId, Long roleId);

    // Buscar todos los roles de un usuario
    List<UserRole> findByUserId(Long userId);

    // Buscar todos los usuarios de un rol
    List<UserRole> findByRoleId(Long roleId);

    // Verificar si existe la relación
    boolean existsByUserIdAndRoleId(Long userId, Long roleId);

    // Contar todas las relaciones
    int count();
}