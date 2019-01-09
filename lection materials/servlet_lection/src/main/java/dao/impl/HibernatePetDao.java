package dao.impl;

import dao.PetDao;
import model.Pet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by eugen on 1/9/19.
 */
public class HibernatePetDao implements PetDao {
    public void insert(Pet pet) {
        Session session = HibernateUtil.getSession();
        session.save(pet);
        session.close();
    }

    public List<Pet> findAll() {
        Session session = HibernateUtil.getSession();
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
        Session session = HibernateUtil.getSession();
        Pet pet = session.get(Pet.class, id);
        session.close();
        return pet;
    }

    public void delete(Integer id) {
        Session session = HibernateUtil.getSession();
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
