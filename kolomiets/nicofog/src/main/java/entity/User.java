package entity;

/**
 * Created by mihail on 11/9/18.
 */
public class User {

    public User(){}

    private long id;
    private String name;
    private String role;

    /**
     * Price 20 sigarets of user smoke
     */
    private Integer sigaretPrice;

    /**
     * Represent like LocalDateTime.now() to string value
     */
    private String dateRegistration;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getSigaretPrice() {
        return sigaretPrice;
    }

    public void setSigaretPrice(Integer sigaretPrice) {
        this.sigaretPrice = sigaretPrice;
    }

    public String getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(String dateRegistration) {
        this.dateRegistration = dateRegistration;
    }
}
