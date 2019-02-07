package service;

import dao.UserDAO;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Service("userService")
public class UserService {
    @Autowired
    UserDAO userDAO;

    private List<User> usersList = new ArrayList<>();


    public void add(User user) throws SQLException {
        userDAO.add(user);
    }

    public void delete(int id) throws SQLException {
        userDAO.delete(id);
    }

    public String getById(int id) throws SQLException {
        return userDAO.getById(id);
    }

    public List<User> getAll() throws SQLException {
        return userDAO.getAll();
    }

    public int getIdByNamePass(User user) throws SQLException {
        return userDAO.getIdByNamePass(user);
    }
}
