package com.hillel.boot.service;


import com.hillel.boot.dao.impl.SpringDataPetDao;
import com.hillel.boot.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eugen on 11/14/18.
 */
@Service
public class PetService {

    @Autowired
    SpringDataPetDao petDao;

    public PetService() {

    }

    public List<Pet> getAllPets() {
        return (List<Pet>) petDao.findAll();
    }

    public List<Pet> getAllPetsByName(String name) {
        return petDao.findByNameLikeIgnoreCase("%" + name + "%");
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
        petDao.save(pet);
    }

    public void deletePet(Integer id) {
        petDao.deleteById(id);
    }
}
