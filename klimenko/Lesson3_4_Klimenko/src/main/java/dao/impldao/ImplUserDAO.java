package dao.impldao;

import dao.MySqlConnector;
import dao.UserDAO;
import entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ImplUserDAO implements UserDAO {
    private Connection connection;

    public ImplUserDAO() {
        this.connection = MySqlConnector.getDbConnection();
    }

    public void deleteUser(int id) {
        String sql = "delete from `real_estate_agency`.`users`  where id = ?; ";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        String sql = "INSERT INTO `real_estate_agency`.`Users` (`name`, `password`, " +
                "`email`) " +
                "VALUES (?, ?, ?);";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            prepareStatementUser(statement, user);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        String sql = "UPDATE `real_estate_agency`.`Users` set `name` = ?, `password` = ?, " +
                "`email` = ?" +
                " where id = ?; ";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            prepareStatementUser(statement, user);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void prepareStatementUser(PreparedStatement statement, User user) throws SQLException {
        statement.setString(1, user.getName());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getEmail());
    }

    public User getUserByName(String name) {

        String sql = "SELECT * from `real_estate_agency`.`Users` where name = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return extractObjectUser(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUser(int id) {
        String sql = "SELECT * from `real_estate_agency`.`Users` where id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return extractObjectUser(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public User extractObjectUser(ResultSet resultSet) throws SQLException {

        String name = resultSet.getString("name");
        String password = resultSet.getString("password");
        String email = resultSet.getString("email");
        int id = resultSet.getInt("id");

        return new User(name, password, email, id);
    }

    public User checkUser(String name, String password) {
        String sql = "SELECT * from `real_estate_agency`.`Users` where name = ? and password=?;";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return extractObjectUser(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * from `real_estate_agency`.`Users`;";
        ArrayList<User> list = new ArrayList<User>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {
                list.add(extractObjectUser(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
