package com.hillel.boot.dao.impl;

import com.hillel.boot.model.Pet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by eugen on 1/23/19.
 */
public interface SpringDataPetDao extends CrudRepository<Pet, Integer> {
    List<Pet> findPetByName(String name);

    List<Pet> findByNameLikeIgnoreCase(String name);

    @Query("update Pet p set age = :field where name = :name")
    void updateField(String field, String name);
}
