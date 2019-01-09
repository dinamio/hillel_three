package app.dao.impl;

import app.entities.Document;


import java.util.List;

public interface DocumentDao {

    void insert(Document document);
    List<Document> findAll();
    List<Document> findDocumentsByName(String name);
    Document find(Integer id);
    void delete(Document document);


}
