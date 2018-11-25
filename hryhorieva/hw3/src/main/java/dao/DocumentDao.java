package dao;

import entity.Document;

import java.util.List;

public interface DocumentDao {
    List<Document> selectAll();
    void insert(Document document);
    void deleteByName(String name);
}
