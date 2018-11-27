package dao.impl;

import entity.ConnectionDataStorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static DBConnection _instance = null;
    private ConnectionDataStorage connectionData = new ConnectionDataStorage();
    private Connection connection;

    private DBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("There are some problems with driver loading");
        }

        try {
            Properties properties = new Properties();
            properties.setProperty("user", connectionData.getUser());
            properties.setProperty("password", connectionData.getPassword());
            properties.setProperty("useSSL", "false");
            this.connection = DriverManager.getConnection("jdbc:mysql://" + connectionData.getHost() +"/" +connectionData.getDatabase() + "?serverTimezone=Europe/Kiev", properties);
        } catch (SQLException e) {
            System.out.println("failed connection");
        }
    }

    public synchronized static DBConnection getInstance() {
        if (_instance == null)
            _instance = new DBConnection();
        return _instance;
    }
    public Connection getConnection(){
        return this.connection;
    }
}
