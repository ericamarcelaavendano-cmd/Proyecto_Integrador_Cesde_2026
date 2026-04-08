package service;

import co.edu.cesde.g.models.User;

import java.util.List;

public interface UserService {
    //Crear User
    User create(User user);

    //Eliminar User
    boolean delete(Long userId);

    //Actualizar  user
    boolean update(User userupdate);

    User findById(Long userId);

    //Buscaar todos los user
    List<User> findAll();

    //Tambien lo puedo buscar con el documento
    boolean existsByUsername(String username);

    User findByUsername(String username);

    User findByEmail(String email);

    //Aqui se cuenta todos los User
    int count();
}
