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

    private static final String SELECT_ALL = "SELECT * FROM documents ORDER BY id";
    private static final String INSERT = "INSERT  INTO  documents (name, date, user)  VALUES  (?,?,?)";
    private static final String DELETE_BY_ID = "DELETE FROM documents WHERE id = ?;";
    private static final String UPDATE_BY_ID = "UPDATE documents SET name = ?, user = ? WHERE id = ?;";

    public JDBCDocumentDao(){}
    public JDBCDocumentDao(Connection connection) {
        this.connection = connection;
        this.userDao = new JDBCUserDao(connection);
    }


    public List<Document> selectAll() {
        List<Document> documentList = new ArrayList<Document>();
        ResultSet rs = null;
        try {
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(SELECT_ALL);
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


    public void insert(Document document) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, document.getName());
            preparedStatement.setTimestamp(2,document.getDate());
            preparedStatement.setInt(3, document.getUser().getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("This document has already been added");
        }
    }


    public void deleteById(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateById(Document document) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, document.getName());
            preparedStatement.setInt(2, document.getUser().getId());
            preparedStatement.setInt(3, document.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}