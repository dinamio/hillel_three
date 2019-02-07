package dao;

import model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Qualifier("documentDAOImpl")
public class DocumentDAOImpl implements DocumentDAO{
    Connection connection;

    Statement stmt = null;
    String INSERT_DOC = "INSERT INTO DOCS VALUES (?,?,?,?);";
    String UPDATE_DOC = "UPDATE DOCS SET NAME=? WHERE ID=?;";
    String DELETE_DOC = "DELETE FROM DOCS WHERE ID=?";
    private String SELECT_ALL = "select * from docs";

    @Override
    public void add(Document doc) throws SQLException {
        connection = ConnectionFactoryDAO.getConnection();
            stmt = connection.createStatement();
            PreparedStatement pstmt = connection.prepareStatement(INSERT_DOC, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, doc.getId());
            pstmt.setString(2, doc.getName());
            pstmt.setString(3, doc.getDate());
            pstmt.setInt(4, doc.getUser_id());
            int rowNumber = pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            int id = 0;
            if(rs.next()) {
                doc.setId(rs.getInt(1));
            }
    }

    @Override
    public void update(Document doc)throws SQLException {
        connection = ConnectionFactoryDAO.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(UPDATE_DOC);
            pstmt.setString(1, doc.getName());
            pstmt.setInt(2, doc.getId());
            pstmt.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        connection = ConnectionFactoryDAO.getConnection();
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM DOCS WHERE ID=" + id);
        }  finally {
            if(stmt != null) {
                stmt.close();
            }
        }
    }

    @Override
    public Document getByID(int id) throws SQLException {
        ResultSet rs = null;
        connection = ConnectionFactoryDAO.getConnection();

        Document doc = new Document();
        try{
            PreparedStatement pstmt = connection.prepareStatement("SELECT NAME FROM DOCS WHERE ID=?;");
            pstmt.setInt(1, doc.getId());
            pstmt.executeUpdate();
            while (rs.next()) {
                doc.setName(rs.getString(1));
            }
        } finally {
            if(connection != null) {
               connection.close();
            }
            if(rs != null) {
                rs.close();
            }
        }
        return doc;
    }

    @Override
    public ArrayList<Document> getAll() throws SQLException{
        connection = ConnectionFactoryDAO.getConnection();
        ArrayList<Document> listDocs = new ArrayList<>();
        stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                Document doc = new Document();
                doc.setId(rs.getInt("id"));
                doc.setName(rs.getString(2));
                doc.setDate(rs.getString(3));
                doc.setUser_id(rs.getInt(4));
                listDocs.add(doc);
            }
        return listDocs;
    }

    @Override
    public int getNumRow() throws SQLException {
        connection = ConnectionFactoryDAO.getConnection();
        int numRows = 0;
        stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM DOCS;");
        while (rs.next()) {
            numRows = rs.getInt(1);
        }
        return numRows;
    }
}
