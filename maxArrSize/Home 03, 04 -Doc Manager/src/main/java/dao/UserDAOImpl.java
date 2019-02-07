package dao;

import model.User;
import model.UserDetailsRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.activation.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Qualifier("userDaoImpl")
public class UserDAOImpl implements UserDAO{

    private Connection connection;

    Statement stmt = null;
    String ADD_USER = "INSERT INTO USERS VALUES (?,?,?);";
    String SELECT_ALL = "SELECT * FROM USERS;";
    String DELETE_USER = "DELETE FROM USERS WHERE ID=?";

    public int getIdByNamePass(User user) throws SQLException {
        int id = 0;
        connection = ConnectionFactoryDAO.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT ID FROM USERS WHERE NAME=? AND PASS=?");
        pstmt.setString(1, user.getName());
        pstmt.setString(2, user.getPass());
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }
    public void add(User user) throws SQLException {
        connection = ConnectionFactoryDAO.getConnection();
       try {
            stmt = connection.createStatement();
            PreparedStatement pstmt = connection.prepareStatement(ADD_USER);
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getPass());
            pstmt.executeUpdate();
        } finally {
            if(connection != null) {
                connection.close();
            }
            if(stmt != null) {
                stmt.close();
            }
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        connection = ConnectionFactoryDAO.getConnection();
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM USERS WHERE ID=" + id);
        }  finally {
            if(connection != null) {
                connection.close();
            }
            if(stmt != null) {
                stmt.close();
            }
        }
    }

    @Override
    public String getById(int id) throws SQLException {
        connection = ConnectionFactoryDAO.getConnection();
        ResultSet rs = null;
        String name = null;
            PreparedStatement pstmt = connection.prepareStatement("SELECT NAME FROM USERS WHERE ID=?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            while (rs.next()) {
                name = rs.getString(1);
            }

        return name;
    }

    @Override
    public ArrayList<User> getAll() throws SQLException {
        connection = ConnectionFactoryDAO.getConnection();
        ArrayList<User> listUsers = new ArrayList<>();
        stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(SELECT_ALL);
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString(2));
            listUsers.add(user);
        }
        return listUsers;
    }
}
