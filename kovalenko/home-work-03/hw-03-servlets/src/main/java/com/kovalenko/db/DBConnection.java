package com.kovalenko.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {

    private static DataSource dataSource;
    private static Connection connection;

    public static Connection getConnection() {
        if(connection == null){
            try {
                connection = getDataSource().getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    private static DataSource getDataSource() {
        if(dataSource == null){
            Context initContext;
            try {
                initContext = new InitialContext();
                dataSource = (DataSource) initContext.lookup("java:/comp/env/jdbc/DocumentDB");
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return dataSource;
    }
}
