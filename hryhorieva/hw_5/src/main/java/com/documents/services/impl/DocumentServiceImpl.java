package com.documents.services.impl;

import com.documents.dao.DocumentDao;
import com.documents.dao.impl.JDBCDocumentDao;
import com.documents.entity.Document;
import com.documents.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    DocumentDao documentDao;

    public DocumentServiceImpl(){}
    public DocumentServiceImpl(JDBCDocumentDao documentDao) {
        this.documentDao = documentDao;
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
