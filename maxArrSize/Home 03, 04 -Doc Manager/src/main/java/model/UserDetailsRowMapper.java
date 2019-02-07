package model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDetailsRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int row) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setPass(rs.getString("pass"));
        return user;
    }
}
