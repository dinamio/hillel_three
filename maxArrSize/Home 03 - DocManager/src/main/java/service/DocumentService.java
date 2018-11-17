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
}
