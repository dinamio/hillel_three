package service;

import model.Document;

import java.util.ArrayList;
import java.util.List;

public class DocumentService {
    private List<Document> docs = new ArrayList<>();

    public List<Document> getAllDocs(){
        return docs;
    }

    public void addDoc(Document newDoc){
        docs.add(newDoc);
    }

    public Document findByName(String name) {
        if (name != null) {
            return docs.stream().filter(document -> document.getName().equals(name)).findFirst().get();
        }
        return  null;
    }

    public void delete(String name) {
        if (name != null) {
            docs.remove(findByName(name));
        }
    }
}
