package dao;

import model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UserDAO {
    public void add(User user)throws SQLException;
    public void delete(int id)throws SQLException;
    public String getById(int id) throws SQLException;
    public ArrayList<User> getAll() throws SQLException;
    public int getIdByNamePass(User user) throws SQLException;
}
