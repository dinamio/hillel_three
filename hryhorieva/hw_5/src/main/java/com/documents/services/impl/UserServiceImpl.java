package com.documents.services.impl;

import com.documents.dao.RoleDao;
import com.documents.dao.UserDao;
import com.documents.entity.Role;
import com.documents.entity.User;
import com.documents.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("HibernateUserDao")
    UserDao userDao;

    @Autowired
    @Qualifier("HibernateRoleDao")
    RoleDao roleDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User userRegistration(User user){
        User newUser = null;
        if(userDao.getByLogin(user.getLogin()) == null) {
            String password = passwordEncoder.encode(user.getPassword());
            List<Role>roles = new ArrayList<>();
            roles.add(roleDao.getByRole("ROLE_USER"));
            System.out.print(roles);
            userDao.insert(new User(user.getLogin(), password, roles));
            newUser = userDao.getByLoginAndPassword(user.getLogin(), password);
        }
        return newUser;
    }

    public User userAuthorization(User user) {
        User userNew = null;
        User currentUser = userDao.getByLoginAndPassword(user.getLogin(), passwordEncoder.encode(user.getPassword()));
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
