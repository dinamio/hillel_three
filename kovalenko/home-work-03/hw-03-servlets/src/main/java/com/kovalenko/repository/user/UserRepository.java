package com.kovalenko.repository.user;

import com.kovalenko.entity.user.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();
    User findByID(long id);
    User findByLogin(String login);
    User save(User user);
    User update(long id, User user);
    void delete(long id);
}
