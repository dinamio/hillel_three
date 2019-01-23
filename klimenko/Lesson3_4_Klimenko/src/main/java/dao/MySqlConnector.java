package dao;

//import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//@Component
public class MySqlConnector {

    public static Connection getDbConnection() {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/real_estate_agency?serverTimezone=UTC&characterEncoding=utf8";
        String pass = "qwerty";
        String user = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}