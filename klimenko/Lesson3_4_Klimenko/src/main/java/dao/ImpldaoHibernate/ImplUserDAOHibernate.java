package dao.ImpldaoHibernate;

import dao.UserDAO;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Qualifier("ImplUserDAOHibernate")
public class ImplUserDAOHibernate implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(getUser(id));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }

    }

    @Override
    public User getUserByName(String name) {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).where(builder.equal(root.get("name"), name));
        Query<User> q = session.createQuery(query);

        List<User> user = q.getResultList();
        if (user.size() == 0)
            return null;
        else
            return user.get(0);

    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.update(user);
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public User getUser(int id) {
        Session session = sessionFactory.openSession();
        User apartment = (User) session.get(User.class, id);
        session.close();
        return apartment;
    }

    @Override
    public User checkUser(String name, String password) {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).where(
                builder.and(
                        builder.equal(root.get("name"), name),
                        builder.equal(root.get("password"), password)));
        Query<User> q = session.createQuery(query);
        User user = q.getResultList().get(0);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        List<User> apartments = session.createQuery("from User").list();
        return apartments;
    }
}
