package com.kovalenko.repository.document.impl;

import com.kovalenko.db.DBConnection;
import com.kovalenko.entity.document.Document;
import com.kovalenko.entity.user.User;
import com.kovalenko.repository.document.DocumentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocumentRepositoryImpl implements DocumentRepository {

    private final static String FIND_ALL_QUERY = "SELECT d.document_id, d.title, d.created, d.user_id, u.name " +
            "FROM documents d INNER JOIN users u ON d.user_id = u.user_id";
    private final static String FIND_BY_ID_QUERY = FIND_ALL_QUERY.concat(" WHERE d.document_id = ?");
    private final static String INSERT_QUERY = "INSERT INTO documents (title, created, user_id) VALUES (?, ?, ?)";
    private final static String UPDATE_QUERY = "UPDATE documents SET title = ? WHERE document_id = ?";
    private final static String DELETE_QUERY = "DELETE FROM documents WHERE document_id = ?";

    @Override
    public List<Document> findAll() {
        List<Document> documents = new ArrayList<>();
        Connection connection;
        PreparedStatement pstm;

        try {
            connection = DBConnection.getConnection();
            pstm = connection.prepareStatement(FIND_ALL_QUERY);
            ResultSet rs = pstm.executeQuery();
            Document document;
            while (rs.next()) {
                document = new Document();
                document.setId(rs.getLong("document_id"));
                document.setTitle(rs.getString("title"));
                document.setCreated(rs.getTimestamp("created").toLocalDateTime());
                document.setAuthor(new User(rs.getLong("user_id"), rs.getString("name")));
                documents.add(document);
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return documents;
    }

    @Override
    public Document findByID(long id) {
        Document document = null;
        Connection connection;
        PreparedStatement pstm;
        try {
            connection = DBConnection.getConnection();
            pstm = connection.prepareStatement(FIND_BY_ID_QUERY);
            pstm.setLong(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                document = new Document();
                document.setId(rs.getLong("document_id"));
                document.setTitle(rs.getString("title"));
                document.setCreated(rs.getTimestamp("created").toLocalDateTime());
                document.setAuthor(new User(rs.getLong("user_id"), rs.getString("name")));
            }

            rs.close();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return document;
    }

    @Override
    public void save(Document document) {
        Connection connection;
        PreparedStatement pstm;
        try {
            connection = DBConnection.getConnection();
            pstm = connection.prepareStatement(INSERT_QUERY);
            pstm.setString(1, document.getTitle());
            pstm.setTimestamp(2, Timestamp.valueOf(document.getCreated()));
            pstm.setLong(3, document.getAuthor().getId());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Document update(long id, Document document) {
        Connection connection;
        PreparedStatement pstm;
        try {
            connection = DBConnection.getConnection();
            pstm = connection.prepareStatement(UPDATE_QUERY);
            pstm.setString(1, document.getTitle());
            pstm.setLong(2, id);
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findByID(id);
    }

    @Override
    public void delete(long id) {
        Connection connection;
        PreparedStatement pstm;
        try {
            connection = DBConnection.getConnection();
            pstm = connection.prepareStatement(DELETE_QUERY);
            pstm.setLong(1, id);
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
