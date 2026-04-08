package service.impl;

import co.edu.cesde.g.models.User;
import repository.UserRepository;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Metòdos crear (create)
    @Override
    public User create(User user) {
        if (isInvalidUser(user) || userRepository.existsByUsername(user.getUsername()))
            return null;
        return userRepository.create(user);
    }

    //Metodo eliminar (delete)
    @Override
    public boolean delete(Long userId) {
        if (userId == null)
            return false;
        return userRepository.delete(userId);
    }

    // Metodo Actualizar (update)
    @Override
    public boolean update(User userupdate) {
        if (isInvalidUser(userupdate) || userupdate.getUserId() == null)
            return false;
        return userRepository.update(userupdate);
    }

    @Override
    public User findById(Long userId) {
        if (userId == null)
            return null;
        return userRepository.findById(userId);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean existsByUsername(String username) {
        if (isBlank(username))
            return false;
        return userRepository.existsByUsername(username);
    }

    @Override
    public User findByUsername(String username) {
        if (isBlank(username))
            return null;
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        if (isBlank(email))
            return null;
        return userRepository.findByEmail(email);
    }

    @Override
    public int count() {
        return userRepository.count();
    }
    //Metodo para validar si el user es invalido
    private boolean isInvalidUser(User user){
        return user == null
                || user.getUserId() == null
                || isBlank(user.getUsername())
                || isBlank(user.getEmail())
                || isBlank(user.getPasswordHash());
    }
    //Metodo para validar sib el texto esta vacio
    private boolean isBlank(String value){
        return value == null || value.isBlank();
    }
}

