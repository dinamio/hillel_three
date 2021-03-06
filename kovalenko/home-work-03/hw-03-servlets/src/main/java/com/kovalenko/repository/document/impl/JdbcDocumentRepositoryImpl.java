package com.kovalenko.repository.document.impl;

import com.kovalenko.db.DBConnection;
import com.kovalenko.entity.document.Document;
import com.kovalenko.entity.user.User;
import com.kovalenko.repository.document.DocumentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Qualifier("jdbcDocumentRepositoryImpl")
public class JdbcDocumentRepositoryImpl implements DocumentRepository {

    private final static String FIND_ALL_QUERY = "SELECT d.document_id, d.title, d.created, d.user_id, u.name " +
            "FROM documents d INNER JOIN users u ON d.user_id = u.user_id";
    private final static String FIND_BY_ID_QUERY = "SELECT d.document_id, d.title, d.created, d.user_id, u.name " +
            "FROM documents d INNER JOIN users u ON d.user_id = u.user_id WHERE d.document_id = ?";
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
            while (rs.next()) {
                documents.add(getDocument(rs));
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return documents;
    }

    private Document getDocument(ResultSet rs) throws SQLException {
        Document document = new Document();
        document.setId(rs.getLong("document_id"));
        document.setTitle(rs.getString("title"));
        document.setCreated(rs.getTimestamp("created").toLocalDateTime());
        document.setAuthor(new User(rs.getLong("user_id"), rs.getString("name")));
        return document;
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
                document = getDocument(rs);
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
