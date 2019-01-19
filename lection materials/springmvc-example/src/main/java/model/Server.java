package model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by eugen on 11/21/17.
 */
@Table
@Entity
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty
    private String name;
    @Size(min = 3, max = 10, message = "Size is not fit")
    @NotNull
    private String description;
    @Column(name = "enabled")
    private Boolean isEnabled;

    public Server() {
    }

    public Integer getMyId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Server(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }
}
