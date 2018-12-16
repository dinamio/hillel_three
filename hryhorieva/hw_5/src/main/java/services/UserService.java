package services;

import dao.impl.JDBCUserDao;
import entity.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    JDBCUserDao userDao;

    public UserService(){}
    public UserService(JDBCUserDao userDao) {
        this.userDao = userDao;
    }

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
