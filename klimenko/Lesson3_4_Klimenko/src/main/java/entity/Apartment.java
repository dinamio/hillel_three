package entity;

public class Apartment extends RealEstate {
    public int floor;
    public int countOfRoom;
    public int size;
    String additionalDescription;


    public Apartment(String address, String typeEstate, int floor,
                     int countOfRoom, int size, String additionalDescription, int estateID, String user, String date) {
        super(address, typeEstate, estateID, user, date);
        this.floor = floor;
        this.countOfRoom = countOfRoom;
        this.size = size;
        this.additionalDescription = additionalDescription;

    }

    public Apartment() {

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
