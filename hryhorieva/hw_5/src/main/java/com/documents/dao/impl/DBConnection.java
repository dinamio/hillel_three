package com.documents.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static DBConnection _instance = null;
    private Connection connection;
    private Properties property = new Properties();
    private String driver;
    private String url;
    private String user;
    private String password;


    private DBConnection(){
        getConnectionData();
        try {
            Class.forName(this.driver);
        } catch (ClassNotFoundException e) {
            System.out.println("There are some problems with driver loading");
        }

        try {
            this.connection = DriverManager.getConnection(this.url, this.user, this.password);
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

    private void getConnectionData(){
        FileInputStream fis;
        try {
            fis = new FileInputStream(getClass().getResource("/liquibase/liquibase.properties").getPath());
            property.load(fis);
            this.driver = property.getProperty("driver");
            this.url = property.getProperty("url");
            this.user = property.getProperty("username");
            this.password = property.getProperty("password");
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }

    }
}
