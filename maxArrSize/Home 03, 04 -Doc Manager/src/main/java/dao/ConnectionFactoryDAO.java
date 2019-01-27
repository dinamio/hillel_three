package dao;

import org.springframework.context.annotation.Bean;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryDAO {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/doc_manager" +
                        "?useSSL=false&useUnicode=true", "root", "V$a5n0d9a");
            } catch (ClassNotFoundException e) {
                System.out.println("ERROR: Unable to Connect to Database.");
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
