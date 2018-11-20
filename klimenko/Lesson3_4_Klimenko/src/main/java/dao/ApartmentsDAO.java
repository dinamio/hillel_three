package dao;

import entity.Apartments;

import java.util.List;

public interface ApartmentsDAO {

    public void deleteApartment(int id);

    public void addApartment(Apartments apartment);

    public void updateApartment(Apartments apartment);

    public Apartments getApartment(int id);

    public List<Apartments> getAllAppartments();

}
