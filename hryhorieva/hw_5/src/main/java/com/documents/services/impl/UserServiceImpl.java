package com.documents.services.impl;

import com.documents.dao.UserDao;
import com.documents.entity.User;
import com.documents.services.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public User userRegistration(User user){
        User newUser = null;
        if(userDao.getByLogin(user.getLogin()) == null) {
            userDao.insert(new User(user.getLogin(), DigestUtils.md5Hex(user.getPassword())));
            newUser = userDao.getByLoginAndPassword(user.getLogin(), DigestUtils.md5Hex(user.getPassword()));
        }
        return newUser;
    }

    public User userAuthorization(User user) {
        User userNew = null;
        User currentUser = userDao.getByLoginAndPassword(user.getLogin(), DigestUtils.md5Hex(user.getPassword()));
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
        return userDao.selectAll();
    }

    public User getByLoginAndPassword(String login, String password){
        return userDao.getByLoginAndPassword(login, password);
    }

    public User getByLogin(String login){
        return userDao.getByLogin(login);
    }

    public User getById(Integer id){
        return userDao.getById(id);
    }
}
