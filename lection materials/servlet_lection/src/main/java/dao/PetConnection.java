package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by eugen on 12/5/18.
 */
public class PetConnection {

    private static PetConnection instance;
    private Connection connection;

    private PetConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pets", "root", "qwerty");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static PetConnection getInstance() {
        if (instance == null) {
            instance = new PetConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
