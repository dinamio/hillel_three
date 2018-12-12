package service;

import model.Document;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DocumentService {
    private List<Document> docs = new ArrayList<>();

    public List<Document> getAllDocs(){
        return docs;
    }

    public void addDoc(Document newDoc){
        long id = docs.size() == 0
                ? 1
                : docs.stream()
                .max(Comparator.comparingLong(Document::getId))
                .get()
                .getId()+1;

        newDoc.setId(id);
        docs.add(newDoc);
    }

    public void delete(long id) {
        if (id != 0) {
           Document document = docs
                   .stream()
                   .filter(doc -> doc.getId() == id).findFirst()
                   .get();

           docs.remove(document);
        }
    }
}
