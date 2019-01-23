package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Password")
    private String password;
    @Column(name = "Email")
    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Apartment> apartment;

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
