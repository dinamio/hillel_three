package service;

import model.Document;

import java.util.ArrayList;
import java.util.List;

public class DocManager {
    private List<Document> docs = new ArrayList<Document>();

    public DocManager(){
        docs.add(new Document("defaultDoc"));
        docs.add(new Document("doc.txt", "2017/02/18"));
        docs.add(new Document("doc.docx", "2018/09/11"));
    }

    public List<Document> getAllDocs(){
        return docs;
    }

    public void addDoc(Document newDoc){
        docs.add(newDoc);
    }
}
