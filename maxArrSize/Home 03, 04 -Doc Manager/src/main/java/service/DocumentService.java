package service;

import dao.DocumentDAO;
import model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("documentService")
public class DocumentService {
    @Autowired
    DocumentDAO documentDAO;

    private List<Document> docs = new ArrayList<Document>();

    public List<Document> getAll() throws SQLException {
        return documentDAO.getAll();
    }

    public Document getByID (int id) throws SQLException {
        return documentDAO.getByID(id);
    }

    public void add(Document newDoc) throws SQLException {
        documentDAO.add(newDoc);
    }

    public void delete(int id) throws SQLException {
        documentDAO.delete(id);
    }

    public void update(Document removedDoc) throws SQLException {
        documentDAO.update(removedDoc);
    }

    public int getNumRow() throws SQLException {
        return documentDAO.getNumRow();
    }
}