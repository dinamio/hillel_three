package dao.ImpldaoHibernate;

import dao.ApartmentsDAO;
import entity.Apartment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Qualifier("ImplApartmentDAOHibernate")
public class ImplApartmentDAOHibernate implements ApartmentsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void deleteApartment(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(getApartment(id));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void addApartment(Apartment apartment) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(apartment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateApartment(Apartment apartment) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
                session.update(apartment);
                transaction.commit();

        } catch (Exception e) {
            transaction.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public Apartment getApartment(int id) {
        Session session = sessionFactory.openSession();
        Apartment apartment = (Apartment) session.get(Apartment.class, id);
        session.close();
        return apartment;
    }

    @Override
    public List<Apartment> getAllAppartments() {
        Session session = sessionFactory.openSession();
        List<Apartment> apartments = session.createQuery("from Apartment ").list();
        return apartments;
    }
}
