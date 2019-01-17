package com.kovalenko.repository.document;

import com.kovalenko.entity.document.Document;

import java.util.List;

public interface DocumentRepository {
    List<Document> findAll();
    Document findByID(long id);
    void save(Document document);
    Document update(long id, Document document);
    void delete(long id);
}
