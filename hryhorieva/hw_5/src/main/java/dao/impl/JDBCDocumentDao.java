package dao.impl;

import dao.DocumentDao;
import entity.Document;
import entity.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCDocumentDao implements DocumentDao {
    Connection connection;
    JDBCUserDao userDao;

    public JDBCDocumentDao(Connection connection) {
        this.connection = connection;
        this.userDao = new JDBCUserDao(connection);
        createTable();
    }

    private void createTable(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS documents (id int PRIMARY KEY AUTO_INCREMENT, name varchar(255) NOT NULL UNIQUE, date timestamp NOT NULL, user int NOT NULL, FOREIGN KEY (user) REFERENCES users(id))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Document> selectAll() {
        List<Document> documentList = new ArrayList<Document>();
        ResultSet rs = null;
        try {
            String selectDataStatement = "SELECT * FROM documents ORDER BY id";
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(selectDataStatement);
            while (rs.next()) {
                Document document = new Document();
                document.setId(rs.getInt("id"));
                document.setName(rs.getString("name"));
                document.setDate(rs.getTimestamp("date"));
                document.setUser(userDao.getById(rs.getInt("user")));
                documentList.add(document);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return documentList;
    }


    public void insert(Document document, User user) {
        try {
            String insertQueryStatement = "INSERT  INTO  documents (name, date, user)  VALUES  (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQueryStatement);
            preparedStatement.setString(1, document.getName());
            preparedStatement.setTimestamp(2,document.getDate());
            preparedStatement.setInt(3, user.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("This document has already been added");
        }
    }


    public void deleteById(Integer id) {
        try {
            String deleteQueryStatement = "DELETE FROM documents WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQueryStatement);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateById(Document document, User user) {
        try {
            String updateQueryStatement = "UPDATE documents SET name = ?, user = ? WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQueryStatement);
            preparedStatement.setString(1, document.getName());
            preparedStatement.setInt(2, user.getId());
            preparedStatement.setInt(3, document.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}