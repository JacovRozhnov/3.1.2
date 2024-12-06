package ru.itmentor.spring.boot_security.demo.dao;


import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {
    List<User> allUsers();

    void saveUser(User user);

    User getById(int id);

    void update(int id,User updatedUser);

    void delete(int id);
}
