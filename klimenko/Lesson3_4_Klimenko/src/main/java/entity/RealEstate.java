package entity;

public abstract class RealEstate {


    private String address;
    private String typeEstate;
    private int estateId;
    private String user;
    private String date;

    public RealEstate(String address, String typeEstate, int estateId, String user, String date) {

        this.address = address;
        this.typeEstate = typeEstate;
        this.estateId = estateId;
        this.user = user;
        this.date = date;
    }

    public RealEstate() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getEstateId() {
        return estateId;
    }

    public void setEstateId(int estateId) {
        this.estateId = estateId;
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
}
