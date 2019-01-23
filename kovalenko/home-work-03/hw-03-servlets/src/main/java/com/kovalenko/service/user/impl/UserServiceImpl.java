package com.kovalenko.service.user.impl;

import com.kovalenko.entity.user.User;
import com.kovalenko.entity.user.role.Role;
import com.kovalenko.entity.user.role.RoleType;
import com.kovalenko.repository.role.RoleRepository;
import com.kovalenko.repository.user.UserRepository;
import com.kovalenko.service.user.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(@Qualifier(value = "hibernateUserRepositoryImpl") UserRepository userRepository,
                           BCryptPasswordEncoder passwordEncoder,
                           RoleRepository roleRepository) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
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
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role role = roleRepository.findByRoleType(RoleType.USER);
        user.setRoles(new HashSet<>(Collections.singleton(role)));
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
