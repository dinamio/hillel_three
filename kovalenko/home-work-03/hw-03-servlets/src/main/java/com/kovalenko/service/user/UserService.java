package com.kovalenko.service.user;

import com.kovalenko.entity.user.User;

import java.util.List;

public interface UserService {

    List<User> find();
    User find(long id);
    User getUserByCredentials(String login, String password);
    User getUserByLogin(String login);
    User register(User user);
    User update(long id, User user);
    void delete(long id);
}
