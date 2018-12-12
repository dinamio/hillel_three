package dao;

import model.Pet;

import java.util.List;

/**
 * Created by eugen on 12/5/18.
 */
public interface PetDao {

    void insert(Pet pet);

    List<Pet> findAll();

    List<Pet> findPetsByName(String name);

    Pet find(Integer id);

    void delete(Integer id);
}
