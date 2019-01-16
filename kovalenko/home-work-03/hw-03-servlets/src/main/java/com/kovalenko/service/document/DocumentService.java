package com.kovalenko.service.document;

import com.kovalenko.binding.UploadDocument;
import com.kovalenko.entity.document.Document;
import com.kovalenko.entity.user.User;

import java.util.List;

public interface DocumentService {
    List<Document> find(User user);
    Document find(long id);
    void save(User author, UploadDocument document);
    Document update(long id, Document document);
    void delete(long id);
}
