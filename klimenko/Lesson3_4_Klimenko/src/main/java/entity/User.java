package entity;

import validation.CheckEmail;

import javax.persistence.*;


import  org.hibernate.validator.constraints.NotBlank;


import java.util.List;

@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int id;

    @Column(name = "Name")
    @NotBlank(message = "Имя не может быть пустым")
    private String name;

    @Column(name = "Password")
    @NotBlank(message = "Пароль не может быть пустым")
    private String password;

    @Column(name = "Email")
    @CheckEmail
    private String email;

    @Column(name = "role")
    private String role;

    @Column(name = "enabled")
    private int enabled;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Apartment> apartment;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User() {
    }

    public List<Apartment> getApartment() {
        return apartment;
    }

    public void setApartment(List<Apartment> apartment) {
        this.apartment = apartment;
    }

    public User(String name, String password, String email, int id) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.id = id;
        this.enabled= 1;
        this.role = "USER";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
