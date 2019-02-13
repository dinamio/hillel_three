package entity;

<<<<<<< HEAD
import org.springframework.web.multipart.MultipartFile;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

=======
>>>>>>> 60cac7ff53855449b2d79895fe9cc70f360cc243
import javax.persistence.*;

@Entity
@Table(name = "apartments")
<<<<<<< HEAD
public class Apartment {

    @NotNull
    private int floor;

    @NotNull
    @Min(value = 1, message = "Количество комнат не может быть меньше 1")
    private int countOfRoom;

    @NotNull
    @Min(value = 1, message = "Размер не может быть меньше 1")
    private int size;

    private String address;
    private String typeEstate;
    private String date;
    private String title;
    private String type;

    @ManyToOne
=======
public class Apartment extends RealEstate {

    public int floor;
    public int countOfRoom;
    public int size;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
>>>>>>> 60cac7ff53855449b2d79895fe9cc70f360cc243
    @JoinColumn(name = "user")
    public User user;

    @Id
    @GeneratedValue
    @Column(name = "IDApartments")
    private int estateId;
    String additionalDescription;
    @Lob
    @Column(name = "picture", columnDefinition = "BLOB")
    private byte[] picture;

    @Transient
    private MultipartFile uploadfile;

    public MultipartFile getUploadfile() {
        return uploadfile;
    }

    public void setUploadfile(MultipartFile uploadfile) {
        this.uploadfile = uploadfile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public String getTypeEstate() {
        return typeEstate;
    }

    public void setTypeEstate(String typeEstate) {
        this.typeEstate = typeEstate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Apartment(String address, String typeEstate, int floor,
<<<<<<< HEAD
                     int countOfRoom, int size, String additionalDescription, int estateID, User user, String date, byte[] picture, MultipartFile uploadfile) {
//        super(address, typeEstate, date);
        this.address = address;
        this.typeEstate = typeEstate;
        this.date = date;
=======
                     int countOfRoom, int size, String additionalDescription, int estateID, User user, String date) {
        super(address, typeEstate, date);
>>>>>>> 60cac7ff53855449b2d79895fe9cc70f360cc243
        this.user = user;
        this.floor = floor;
        this.countOfRoom = countOfRoom;
        this.size = size;
        this.estateId = estateID;
        this.additionalDescription = additionalDescription;
        this.picture = picture;
        this.uploadfile = uploadfile;
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
