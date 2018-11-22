package com.kovalenko.service.user.impl;

import com.kovalenko.entity.user.User;
import com.kovalenko.repository.user.UserRepository;
import com.kovalenko.repository.user.impl.UserRepositoryImpl;
import com.kovalenko.service.user.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public List<User> find() {
        return userRepository.find();
    }

    @Override
    public User find(long id) {
        return userRepository.find(id);
    }

    @Override
    public User getUserByCredentials(String login, String password) {
        return userRepository.findByCredentials(login, password);
    }

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(long id, User user) {
        return userRepository.update(id, user);
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }
}
