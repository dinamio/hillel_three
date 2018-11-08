package com.kovalenko.repository.document.impl;

import com.kovalenko.entity.document.Document;
import com.kovalenko.repository.document.DocumentRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DocumentRepositoryImpl implements DocumentRepository {

    private List<Document> documents = Collections.synchronizedList(new ArrayList<>());

    @Override
    public List<Document> find() {

        return documents;
    }

    @Override
    public Document find(long id) {

        return documents
                .stream()
                .filter(document -> document.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Document save(Document document) {

        long maxID = documents.size() == 0
                ? 0
                : documents.get(documents.size()-1).getId();

        document.setId(maxID+1);
        documents.add(document);
        return document;
    }

    @Override
    public Document update(long id, Document document) {

        Document updateDocument = find(id);
        if (updateDocument != null) {
            updateDocument.setTitle(document.getTitle());
            return updateDocument;
        }
        return null;
    }

    @Override
    public void delete(long id) {

        Document removeDocument = find(id);
        if (removeDocument != null) {
            documents.remove(removeDocument);
        }
    }
}
