package entity;

import java.sql.Timestamp;
import java.util.Date;

public class Document {
    private Integer id;
    private String name;
    private Timestamp date;

    public Document(){}

    public Document(Integer id, String name, Timestamp date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Document(String name, Timestamp date) {
        this.name = name;
        this.date = date;
    }
    public Document(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
