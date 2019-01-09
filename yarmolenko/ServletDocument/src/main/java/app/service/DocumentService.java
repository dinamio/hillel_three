package app.service;



import app.dao.impl.DocumentDao;
import app.dao.impl.DocumentDaoImpl;
import app.entities.Document;

import java.util.List;

public class DocumentService {

    private DocumentDao documentDao = new DocumentDaoImpl();

    public DocumentService() {

    }

    public List<Document> getAllDocuments() {
        return documentDao.findAll();
    }

    public List<Document> getAllDocumentsByName(String name) {
        return documentDao.findDocumentsByName(name);
    }

    public void addDocument(Document document){
        documentDao.insert(document);
    }

    public Document findDocumentById(Integer id){
        return documentDao.find(id);
    }

    public void RemoveDocument(Document document){
        documentDao.delete(document);
    }
}
