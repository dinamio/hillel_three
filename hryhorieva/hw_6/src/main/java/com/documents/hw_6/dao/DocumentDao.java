package com.documents.hw_6.dao;

import com.documents.hw_6.entity.Document;

import java.util.List;

public interface DocumentDao {
    List<Document> selectAll();
    void insert(Document document);
    void deleteById(Integer id);
    void updateById(Document document);
    Document getById(Integer id);
}
