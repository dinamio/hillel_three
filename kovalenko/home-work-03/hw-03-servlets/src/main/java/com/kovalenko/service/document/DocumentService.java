package com.kovalenko.service.document;

import com.kovalenko.entity.document.Document;

import java.util.List;

public interface DocumentService {
    List<Document> find();
    Document find(long id);
    void save(Document document);
    Document update(long id, Document document);
    void delete(long id);
}
