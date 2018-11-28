package service;

import model.Document;

import java.util.ArrayList;
import java.util.List;

public class DocumentService {
    private List<Document> docs = new ArrayList<Document>();

    public List<Document> getAllDocs(){
        return docs;
    }

    public Document getDocById (long id) {
        for(Document _doc : docs) {
            if (_doc.getId() == id){
                return _doc;
            }
        }
        return null;
    }

    public void addDoc(Document newDoc){

        long id = docs.size();
        if(id == 0) {
            id = 1;
        } else {
            Document tempDoc = docs.get(docs.size() - 1);
            id = tempDoc.getId() + 1;
        }
        newDoc.setId(id);
        docs.add(newDoc);
    }

    public void deleteDoc(Document removedDoc) {
        docs.remove(removedDoc);
    }
}