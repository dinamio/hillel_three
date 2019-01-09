package service;

import dao.PetDao;
import dao.impl.HibernatePetDao;
import model.Pet;

import java.util.List;

/**
 * Created by eugen on 11/14/18.
 */
public class PetService {

    PetDao petDao = new HibernatePetDao();

    public PetService() {

    }

    public List<Pet> getAllPets() {
        return petDao.findAll();
    }

    public List<Pet> getAllPetsByName(String name) {
        return petDao.findPetsByName(name);
    }

    public void addOneYear(Integer id) {
        /*for (int i = 0; i < pets.size(); i++) {
            Pet pet = pets.get(i);
            if (pet.getId().equals(id)) {
                pet.setAge(pet.getAge() + 1);
            }
        }*/
    }

    public void savePet(Pet pet) {
        petDao.insert(pet);
    }

    public void deletePet(Integer id) {
        petDao.delete(id);
    }
}
