package app.dao;

import java.sql.*;


public class DocumentConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/document_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static DocumentConnection instance;
    private Connection connection;

    private DocumentConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DocumentConnection getInstance(){
        if (instance == null){
            instance = new DocumentConnection();
        }
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }
}
