package repository.impl;

import co.edu.cesde.g.models.User;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryInMemory implements UserRepository {

    private final List<User> users;
    private Long nextUserId;

    public UserRepositoryInMemory() {
        this.users = new ArrayList<>();
        this.nextUserId = 1L;
    }

    @Override
    public User create(User user) {
        if (user == null) {
            return null;
        }
        if (existsByUsername(user.getUsername())) {
            return null;
        }
        user.setUserId(nextUserId++);
        users.add(user);
        return user;
    }

    // Metodo eliminar Rol
    @Override
    public boolean delete(Long userId) {
        User user = findById(userId);
        if (user == null) {
            return false;
        }
        return users.remove(user);
    }

    // Metodo actualizar Rol
    @Override
    public boolean update(User userupdate) {
        if (userupdate == null || userupdate.getUserId() == null) {
            return false;
        }
        for (User user : users) {
            if (!user.getUserId().equals(userupdate.getUserId())
                    && user.getUsername().equals(userupdate.getUsername())) {
                return false;
            }
        }
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equals(userupdate.getUserId())) {
                users.set(i, userupdate);
                return true;
            }
        }
        return false;
    }

    // Metodo buscar por Id
    @Override
    public User findById(Long userId) {
        if (userId == null) {
            return null;
        }
        for (User user: users) {
            if (userId.equals(user.getUserId())) {
                return user;
            }
        }
        return null;
    }

    // Metodo buscar todos
    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    // Metodo verificar si existe por nombre
    @Override
    public boolean existsByUsername(String username) {
        return findByUsername(username) != null;
    }

    // Metodo buscar por nombre
    @Override
    public User findByUsername(String username) {
        if (username == null || username.isBlank()) {
            return null;
        }
        for (User user : users) {
            if (username.equals(user.getUsername())) {
                return user;
            }
        }
        return null;
    }

    public User findByEmail(String email) {
        if (email == null || email.isBlank()) {
            return null;
        }
        for (User user : users) {
            if (email.equals(user.getEmail())) {
                return user;
            }
        }
        return null;
    }

    // Metodo contar roles
    @Override
    public int count() {
        return users.size();
    }
}