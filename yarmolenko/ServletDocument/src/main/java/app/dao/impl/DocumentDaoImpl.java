package app.dao.impl;

import app.dao.DocumentConnection;
import app.entities.Document;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocumentDaoImpl implements DocumentDao {


    private Connection connection;

    public DocumentDaoImpl() {

        connection = DocumentConnection.getInstance().getConnection();

    }

    public void insert(Document document) {

        String sql = "INSERT INTO documents_table (id, name) VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, document.getId());
            statement.setString(2, document.getName());
            statement.setTimestamp(3, document.getDate());
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Document> findAll(){

        List<Document> listDocument = new ArrayList<>();
        String sql = "SELECT * FROM documents_table";

        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Timestamp date = resultSet.getTimestamp("date");
                Document document = new Document(id, name, date);
                listDocument.add(document);
                resultSet.close();
                statement.close();
        }
           } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDocument;
    }

    public List<Document> findDocumentsByName(String name) {

        List<Document> listDocument = new ArrayList<>();
        String SELECT_ALL_BY_NAME = "select * from documents_table where name = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Document document = new Document();
                document.setId(resultSet.getInt("id"));
                document.setName(resultSet.getString("name"));
                document.setDate(resultSet.getTimestamp("date"));
                listDocument.add(document);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDocument;
    }


    public Document find(Integer id) {

        Document document = null;
        String sql = "SELECT * FROM documents_table WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                Timestamp date = resultSet.getTimestamp("date");
                document = new Document(id, name, date);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return document;
    }


    public void delete(Document document) {

        String sql = "DELETE FROM documents_table where id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, document.getId());
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
