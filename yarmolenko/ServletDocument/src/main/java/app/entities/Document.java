package app.entities;



import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Document {

    private int id;
    private String name;
    private Timestamp date;

    public Document() {
    }

    public Document(String name) {
        this.name = name;
    }

    public Document(int id, String name, Timestamp date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }
}
