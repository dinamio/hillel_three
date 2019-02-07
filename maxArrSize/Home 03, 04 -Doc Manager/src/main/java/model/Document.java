package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Document {
    private int id;
    private String name;
    private String date;
    private int user_id;

    public Document(){
    }

    public Document(String docName, String date, int user_id){
        this.id = 0;
        name = docName;
        this.date = date;
        this.user_id = user_id;
    }

    public Document(int id, String docName, String date, int user_id){

        this.id = id;
        name = docName;
        this.date = date;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate(){
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUser_id() {return this.user_id;}

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Document{" +
                "name='" + name + '\'' +
                ", date=" + date + '\'' +
                ", creator=" + user_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document doc = (Document) o;

        return id == doc.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

}
