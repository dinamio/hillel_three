package model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by eugen on 11/3/17.
 */
@Entity
public class Genre {

    @Id
    @GeneratedValue
    Integer id;

    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }

    String name;

    @OneToMany(mappedBy = "genre", fetch = FetchType.EAGER)
    List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
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
}
