package com.kovalenko.repository.user.impl;

import com.kovalenko.entity.user.User;
import com.kovalenko.repository.user.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private static List<User> users = Collections.synchronizedList(new ArrayList<>());

    @Override
    public List<User> find() {
        return users;
    }

    @Override
    public User find(long id) {
        return users
                .stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public User findByCredentials(String login, String password) {
        return users
                .stream()
                .filter(user -> user.getLogin().equals(login) && user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User findByLogin(String login) {
        return users
                .stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User save(User user) {
        long maxID = users.size() == 0
                ? 0
                : users.get(users.size()-1).getId();

        user.setId(maxID+1);
        users.add(user);
        return user;
    }

    @Override
    public User update(long id, User user) {
        User updateUser = find(id);
        if (updateUser != null) {
            updateUser.setName(user.getName());
            return updateUser;
        }
        return null;
    }

    @Override
    public void delete(long id) {
        User removeUser = find(id);
        if (removeUser != null) {
            users.remove(removeUser);
        }
    }
}
