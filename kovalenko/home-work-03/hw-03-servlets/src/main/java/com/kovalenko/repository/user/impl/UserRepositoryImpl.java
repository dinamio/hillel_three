package com.kovalenko.repository.user.impl;

import com.kovalenko.db.DBConnection;
import com.kovalenko.entity.user.User;
import com.kovalenko.repository.user.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final static String FIND_ALL_QUERY = "SELECT user_id, name, login FROM users";
    private final static String FIND_BY_ID_QUERY = FIND_ALL_QUERY.concat(" FROM users WHERE user_id = ?");
    private final static String FIND_BY_LOGIN_QUERY = "SELECT user_id, name, login, password FROM users WHERE login = ?";
    private final static String INSERT_QUERY = "INSERT INTO users (name, login, password) VALUES (?, ?, ?)";
    private final static String UPDATE_QUERY = "UPDATE users SET name = ? WHERE user_id = ?";
    private final static String DELETE_QUERY = "DELETE FROM users WHERE user_id = ?";

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        Connection connection;
        PreparedStatement pstm;
        try {
            connection = DBConnection.getConnection();
            pstm  = connection.prepareStatement(FIND_ALL_QUERY);
            ResultSet rs = pstm.executeQuery();
            User user;
            while (rs.next()) {
                user = new User();
                user.setId(rs.getLong("user_id"));
                user.setName(rs.getString("name"));
                user.setLogin(rs.getString("login"));
                users.add(user);
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findByID(long id) {
        User user = null;
        Connection connection;
        PreparedStatement pstm;
        try {
            connection = DBConnection.getConnection();
            pstm  = connection.prepareStatement(FIND_BY_ID_QUERY);
            pstm.setLong(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setLogin(rs.getString("login"));
            }

            rs.close();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByLogin(String login) {

        User user = null;
        Connection connection;
        PreparedStatement pstm;
        try {
            connection = DBConnection.getConnection();
            pstm = connection.prepareStatement(FIND_BY_LOGIN_QUERY);
            pstm.setString(1, login);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
            }

            rs.close();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User save(User user) {
        Connection connection;
        PreparedStatement pstm;
        try {
            connection = DBConnection.getConnection();
            pstm = connection.prepareStatement(INSERT_QUERY);
            pstm.setString(1, user.getName());
            pstm.setString(2, user.getLogin());
            pstm.setString(3, user.getPassword());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findByLogin(user.getLogin());
    }

    @Override
    public User update(long id, User user) {
        Connection connection;
        PreparedStatement pstm;
        try {
            connection = DBConnection.getConnection();
            pstm = connection.prepareStatement(UPDATE_QUERY);
            pstm.setString(1, user.getName());
            pstm.setLong(2, id);
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findByID(id);
    }

    @Override
    public void delete(long id) {
        Connection connection;
        PreparedStatement pstm;
        try {
            connection = DBConnection.getConnection();
            pstm = connection.prepareStatement(DELETE_QUERY);
            pstm.setLong(1, id);
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
