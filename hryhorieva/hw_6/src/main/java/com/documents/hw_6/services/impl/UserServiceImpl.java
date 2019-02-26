package com.documents.hw_6.services.impl;

import com.documents.hw_6.dao.RoleDao;
import com.documents.hw_6.dao.SpringDataRoleDao;
import com.documents.hw_6.dao.SpringDataUserDao;
import com.documents.hw_6.dao.UserDao;
import com.documents.hw_6.entity.Role;
import com.documents.hw_6.entity.User;
import com.documents.hw_6.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    SpringDataUserDao userDao;

    @Autowired
    SpringDataRoleDao roleDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User userRegistration(User user){
        User newUser = null;
        if(userDao.findUserByLogin(user.getLogin()) == null) {
            String password = passwordEncoder.encode(user.getPassword());
            List<Role>roles = new ArrayList<>();
            roles.add(roleDao.findRoleByRole("ROLE_USER"));
            System.out.print(roles);
            userDao.save(new User(user.getLogin(), password, roles));
            newUser = userDao.findUserByLoginAndPassword(user.getLogin(), password);
        }
        return newUser;
    }

    public User userAuthorization(User user) {
        User userNew = null;
        User currentUser = userDao.findUserByLoginAndPassword(user.getLogin(), passwordEncoder.encode(user.getPassword()));
        if (currentUser != null) {
            userNew = currentUser;
        }
        return userNew;
    }

    public boolean deleteUserById(Integer id){
        boolean result = false;
        userDao.deleteById(id);
        return result;
    }

    public List<User> selectUsers(){
        return userDao.findAll();
    }

    public User getByLoginAndPassword(String login, String password){
        return userDao.findUserByLoginAndPassword(login, password);
    }

    public User getByLogin(String login){
        return userDao.findUserByLogin(login);
    }

    public User getById(Integer id){
        return userDao.findUserById(id);
    }


}
