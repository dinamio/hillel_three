package com.kovalenko.repository.document;

import com.kovalenko.entity.document.Document;

import java.util.List;

public interface DocumentRepository {

    List<Document> find();
    Document find(long id);
    Document save(Document document);
    Document update(long id, Document document);
    void delete(long id);
}
