package com.kovalenko.service.document.impl;

import com.kovalenko.binding.UploadDocument;
import com.kovalenko.entity.document.Document;
import com.kovalenko.repository.document.DocumentRepository;
import com.kovalenko.service.document.DocumentService;
import com.kovalenko.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    private final UserService userService;

    @Autowired
    public DocumentServiceImpl(@Qualifier(value = "hibernateDocumentRepositoryImpl") DocumentRepository documentRepository,
                               UserService userService) {

        this.documentRepository = documentRepository;
        this.userService = userService;
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
    public void save(String authorLogin, UploadDocument document) {
        Document savedDocument = new Document();
        savedDocument.setAuthor(userService.getUserByLogin(authorLogin));
        savedDocument.setCreated(LocalDateTime.now());
        savedDocument.setDescription(document.getDescription());

        MultipartFile file = document.getFile();
        savedDocument.setTitle(file.getOriginalFilename());
        savedDocument.setType(file.getContentType());
        try {
            savedDocument.setContent(file.getBytes());
        } catch (IOException e) {
            savedDocument.setContent(null);
        }
        documentRepository.save(savedDocument);
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
