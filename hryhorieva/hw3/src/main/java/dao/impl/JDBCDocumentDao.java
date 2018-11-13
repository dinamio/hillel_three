package dao.impl;

import dao.DocumentDao;
import entity.Document;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCDocumentDao implements DocumentDao {
    Connection connection;

    public JDBCDocumentDao(Connection connection) {
        this.connection = connection;
        createTable();
    }

    private void createTable(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS documents (id int PRIMARY KEY AUTO_INCREMENT, name varchar(255) NOT NULL UNIQUE, date timestamp NOT NULL);");
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
            String insertQueryStatement = "INSERT  INTO  documents (name, date)  VALUES  (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQueryStatement);
            preparedStatement.setString(1, document.getName());
            preparedStatement.setTimestamp(2,document.getDate());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("This document has already been added");
        }
    }


    public void deleteByName(String name) {

    }
}
