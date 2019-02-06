package entity;

import javax.persistence.MappedSuperclass;


public abstract class RealEstate {


    private String address;
    private String typeEstate;
    private String date;

    public RealEstate(String address, String typeEstate, String date) {

        this.address = address;
        this.typeEstate = typeEstate;
        this.date = date;
    }

    public RealEstate() {
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
