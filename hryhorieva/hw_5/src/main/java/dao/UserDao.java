package dao;

import entity.Document;
import entity.User;

import java.util.List;

public interface UserDao {
    List<User> selectAll();
    User getByLoginAndPassword(String login, String password);
    User getById(Integer id);
    void insert(User user);
    void deleteById(Integer id);
    void updateById(User user);
}
