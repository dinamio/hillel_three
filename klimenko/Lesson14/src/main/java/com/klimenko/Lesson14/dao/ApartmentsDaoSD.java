package com.klimenko.Lesson14.dao;

import com.klimenko.Lesson14.entity.Apartment;
import com.klimenko.Lesson14.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApartmentsDaoSD extends CrudRepository<Apartment, Integer> {

    void deleteByEstateId(int id);

    Apartment findApartmentByEstateId(int id);

    List<Apartment> findAll();
}
