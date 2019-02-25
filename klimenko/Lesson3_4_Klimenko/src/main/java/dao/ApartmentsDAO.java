package dao;

import entity.Apartment;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface ApartmentsDAO {

    public void deleteApartment(int id);

    public void addApartment(Apartment apartment);

    public void updateApartment(Apartment apartment);

    public Apartment getApartment(int id);

    public List<Apartment> getAllAppartments();

}
