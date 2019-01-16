package com.hillel.test.model;


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

    @Override
    public String toString() {
        return "Server{" +
                "isEnabled=" + isEnabled +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Server server = (Server) o;

        if (name != null ? !name.equals(server.name) : server.name != null) return false;
        if (description != null ? !description.equals(server.description) : server.description != null) return false;
        return isEnabled != null ? isEnabled.equals(server.isEnabled) : server.isEnabled == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (isEnabled != null ? isEnabled.hashCode() : 0);
        return result;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty
    private String name;
    @Size(min = 3, max = 5)
    @NotNull
    private String description;
    @Column(name = "enabled")
    private Boolean isEnabled;

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

    public Integer getId() {
        return id;
    }
}
