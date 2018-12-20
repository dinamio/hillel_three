package com.kovalenko.service.user.impl;

import com.kovalenko.entity.user.User;
import com.kovalenko.repository.user.UserRepository;
import com.kovalenko.service.user.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> find() {
        return userRepository.findAll();
    }

    @Override
    public User find(long id) {
        return userRepository.findByID(id);
    }

    @Override
    public User getUserByCredentials(String login, String password) {
        User user = userRepository.findByLogin(login);
        return user != null && BCrypt.checkpw(password, user.getPassword())
                ? user
                : null;
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User register(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
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