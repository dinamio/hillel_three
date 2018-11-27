package dao.impl;

import dao.DocumentDao;
import dao.UserDao;
import entity.Document;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUserDao implements UserDao {
    Connection connection;

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
        createTable();
    }

    private void createTable(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS users (id int PRIMARY KEY AUTO_INCREMENT, login varchar(255) NOT NULL UNIQUE, password varchar(255) NOT NULL);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> selectAll() {
        List<User> userList = new ArrayList<User>();
        ResultSet rs = null;
        try {
            String selectDataStatement = "SELECT * FROM users ORDER BY id";
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(selectDataStatement);
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
          User user1 = null;
          ResultSet rs = null;
          List<User> userList = new ArrayList<User>();
          try { String selectDataStatement = "SELECT * FROM users WHERE login = ? AND password = ?";
              PreparedStatement preparedStatement = connection.prepareStatement(selectDataStatement);
              preparedStatement.setString(1, login);
              preparedStatement.setString(2,password);
              rs = preparedStatement.executeQuery();
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

    public User getById(Integer id){
        User user1 = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<User>();
        try { String selectDataStatement = "SELECT * FROM users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectDataStatement);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
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


    public void insert(User user) {
        try {
            String insertQueryStatement = "INSERT  INTO  users (login, password)  VALUES  (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQueryStatement);
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
            String deleteQueryStatement = "DELETE FROM users WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQueryStatement);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateById(User user) {

    }
}