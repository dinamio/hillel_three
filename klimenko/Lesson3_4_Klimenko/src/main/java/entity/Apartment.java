package entity;

import javax.persistence.*;

@Entity
@Table(name = "apartments")
public class Apartment extends RealEstate {

    public int floor;
    public int countOfRoom;
    public int size;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    public User user;

    @Id
    @GeneratedValue
    @Column(name = "IDApartments")
    private int estateId;
    String additionalDescription;


    public Apartment(String address, String typeEstate, int floor,
                     int countOfRoom, int size, String additionalDescription, int estateID, User user, String date) {
        super(address, typeEstate, date);
        this.user = user;
        this.floor = floor;
        this.countOfRoom = countOfRoom;
        this.size = size;
        this.estateId = estateID;
        this.additionalDescription = additionalDescription;

    }

    public Apartment() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getEstateId() {
        return estateId;
    }

    public void setEstateId(int estateId) {
        this.estateId = estateId;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getCountOfRoom() {
        return countOfRoom;
    }

    public void setCountOfRoom(int countOfRoom) {
        this.countOfRoom = countOfRoom;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getAdditionalDescription() {
        return additionalDescription;
    }


    public void setAdditionalDescription(String additionalDescription) {
        this.additionalDescription = additionalDescription;
    }
}
