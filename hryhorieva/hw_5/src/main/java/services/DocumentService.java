package services;

import dao.impl.JDBCDocumentDao;
import entity.Document;

import java.util.List;

public class DocumentService {
    JDBCDocumentDao documentDao;

    public DocumentService(){}
    public DocumentService(JDBCDocumentDao documentDaoDao) {
        this.documentDao = documentDaoDao;
    }

    public List<Document> allDocuments(){
        return documentDao.selectAll();
    }

    public void newDocument(Document document){
        documentDao.insert(document);
    }

    public void updateById(Document document){
        documentDao.updateById(document);
    }

    public void deleteById(Integer id){
        documentDao.deleteById(id);
    }
}
