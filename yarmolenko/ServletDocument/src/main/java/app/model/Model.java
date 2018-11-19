package app.model;

import app.entities.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static Model instance = new Model();

    private List<Document> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new ArrayList<>();
    }

    public void add(Document document) {
        model.add(document);
    }

    public void delete(Document document) {
        model.remove(document);
    }

    public List<String> list() {
        return model.stream()
                .map(Document::getName)
                .collect(Collectors.toList());
    }
}
