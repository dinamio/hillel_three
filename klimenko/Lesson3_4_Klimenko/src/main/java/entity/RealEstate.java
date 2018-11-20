package entity;

public abstract class RealEstate {


    private String address;
    private String typeEstate;
    private int estateId;

    public RealEstate(String address, String typeEstate,int estateId) {

        this.address = address;
        this.typeEstate = typeEstate;
        this.estateId = estateId;
    }

    public RealEstate() {
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
