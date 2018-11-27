package dao;

import entity.Document;
import entity.User;

import java.util.List;

public interface DocumentDao {
    List<Document> selectAll();
    void insert(Document document, User user);
    void deleteById(Integer id);
    void updateById(Document document, User user);
}
