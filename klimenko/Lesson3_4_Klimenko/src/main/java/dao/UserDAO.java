package dao;

import entity.User;

import java.util.List;

public interface UserDAO {

    public void deleteUser(int id);

    public void addUser(User user);

    public User getUserByName(String name);

    public void updateUser(User user);

    public User getUser(int id);

    public User checkUser(String name, String password);

    public List<User> getAllUsers();

}
