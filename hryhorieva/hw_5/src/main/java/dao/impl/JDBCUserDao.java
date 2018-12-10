package dao.impl;

import dao.DocumentDao;
import dao.UserDao;
import entity.Document;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDBCUserDao implements UserDao {
    Connection connection;

    private static final String SELECT_ALL = "SELECT * FROM users ORDER BY id";
    private static final String SELECT_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE login = ? AND password = ?";
    private static final String SELECT_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String INSERT = "INSERT  INTO  users (login, password)  VALUES  (?,?)";
    private static final String DELETE = "DELETE FROM users WHERE id = ?";

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    public List<User> selectAll() {
        List<User> userList = new ArrayList<User>();
        ResultSet rs = null;
        try {
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(SELECT_ALL);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                userList.add(user);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public User getByLoginAndPassword(String login, String password){
        List<Object>parameters = new ArrayList<>();
        parameters.add(login);
        parameters.add(password);
        return getWithParameters(SELECT_BY_LOGIN_AND_PASSWORD,parameters);
    }

    public User getByLogin(String login){
        List<Object>parameters = new ArrayList<>();
        parameters.add(login);
        return getWithParameters(SELECT_BY_LOGIN,parameters);
    }

    public User getById(Integer id){
        List<Object>parameters = new ArrayList<>();
        parameters.add(id);
        return getWithParameters(SELECT_BY_ID,parameters);
    }


    public void insert(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("This user already exists");
        }
    }


    public void deleteById(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateById(User user) {

    }

    private User getWithParameters(String query, List<?> parameters){
        User user1 = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<User>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for(int i=0; i<parameters.size(); i++){
                if(parameters.get(i) instanceof Number){
                    preparedStatement.setInt(i+1, (int)(Object)parameters.get(i));
                }
                if(parameters.get(i) instanceof String){
                    preparedStatement.setString(i+1, (String)(Object)parameters.get(i));
                }
            }

            rs = preparedStatement.executeQuery();
            if(!rs.isBeforeFirst()){
                return null;
            }

            rs.first();

            User currentUser = new User();
            currentUser.setId(rs.getInt("id"));
            currentUser.setLogin(rs.getString("login"));
            currentUser.setPassword(rs.getString("password"));

            user1 = currentUser;

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user1;
    }
}