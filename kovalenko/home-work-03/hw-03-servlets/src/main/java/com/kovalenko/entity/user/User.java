package com.kovalenko.entity.user;

import com.kovalenko.entity.document.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @NotBlank
    private String name;
    @NotBlank
    private String login;
    @NotBlank
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
    private List<Document> documents;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
