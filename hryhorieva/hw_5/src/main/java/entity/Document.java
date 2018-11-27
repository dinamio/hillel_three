package entity;

import java.sql.Timestamp;
import java.util.Date;

public class Document {
    private Integer id;
    private String name;
    private Timestamp date;
    private User user;


    public Document() {
    }

    public Document(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Document(Integer id, String name, User user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    public Document(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                ", user=" + user +
                '}';
    }
}
