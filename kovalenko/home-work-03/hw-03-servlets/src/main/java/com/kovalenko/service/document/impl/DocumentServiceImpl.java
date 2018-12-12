package com.kovalenko.service.document.impl;

import com.kovalenko.entity.document.Document;
import com.kovalenko.repository.document.DocumentRepository;
import com.kovalenko.repository.document.impl.DocumentRepositoryImpl;
import com.kovalenko.service.document.DocumentService;

import java.time.LocalDateTime;
import java.util.List;

public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentServiceImpl() {
        documentRepository = new DocumentRepositoryImpl();
    }

    @Override
    public List<Document> find() {
        return documentRepository.findAll();
    }

    @Override
    public Document find(long id) {
        return documentRepository.findByID(id);
    }

    @Override
    public void save(Document document) {
        document.setCreated(LocalDateTime.now());
        documentRepository.save(document);
    }

    @Override
    public Document update(long id, Document document) {
        return documentRepository.update(id, document);
    }

    @Override
    public void delete(long id) {
        documentRepository.delete(id);
    }
}
