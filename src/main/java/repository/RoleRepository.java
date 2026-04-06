package repository;

import co.edu.cesde.g.models.Role;


import java.util.List;

public interface RoleRepository {

    //Crear Role
    Role create(Role role);

    //Eliminar Role
    boolean delete(Long roleId);

    //Actualizar Role
    boolean update(Role roleupdate);

    Role findById(Long roleId);

    //Buscar todos los roles .
    List<Role> findAll();

    //Tambien lo puedo buscar con el DocumenNumber
    boolean existsByName(String name);

    Role findByName(String name);

    int count();


}
