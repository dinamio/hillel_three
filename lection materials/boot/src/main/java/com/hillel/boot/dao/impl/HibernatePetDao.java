package com.hillel.boot.dao.impl;

import com.hillel.boot.dao.PetDao;
import com.hillel.boot.model.Pet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by eugen on 1/9/19.
 */
public class HibernatePetDao implements PetDao {

    @Autowired
    EntityManager entityManager;

    public void insert(Pet pet) {
        Session session = entityManager.unwrap(Session.class);
        session.save(pet);
        session.close();
    }

    public List<Pet> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Pet");
        System.out.println("Before query");
        List list = query.list();
        session.close();
        return list;
    }

    public List<Pet> findPetsByName(String name) {
        return null;
    }

    public Pet find(Integer id) {
        Session session = entityManager.unwrap(Session.class);
        Pet pet = session.get(Pet.class, id);
        session.close();
        return pet;
    }

    public void delete(Integer id) {
        Session session = entityManager.unwrap(Session.class);
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(find(id));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }

    }
}
