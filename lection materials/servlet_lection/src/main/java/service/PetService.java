package service;

import model.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugen on 11/14/18.
 */
public class PetService {

    List<Pet> pets = new ArrayList<Pet>();

    public PetService() {
        pets.add(new Pet(1, "Mosha", 6));
        pets.add(new Pet(2, "Tuzik", 1));
        pets.add(new Pet(3, "Kesha", 2));
    }

    public List<Pet> getAllPets() {
        return pets;
    }

    public void addOneYear(Integer id) {
        for (int i = 0; i < pets.size(); i++) {
            Pet pet = pets.get(i);
            if (pet.getId().equals(id)) {
                pet.setAge(pet.getAge() + 1);
            }
        }
    }
}
