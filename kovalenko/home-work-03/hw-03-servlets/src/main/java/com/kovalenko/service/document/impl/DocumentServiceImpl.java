package com.kovalenko.service.document.impl;

import com.kovalenko.entity.document.Document;
import com.kovalenko.entity.user.User;
import com.kovalenko.repository.document.DocumentRepository;
import com.kovalenko.service.document.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public List<Document> find(User user) {
        return documentRepository.findAll(user.getId());
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
