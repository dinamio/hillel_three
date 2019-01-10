package com.kovalenko.repository.user.impl;

import com.kovalenko.entity.user.User;
import com.kovalenko.repository.user.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("hibernateUserRepositoryImpl")
public class HibernateUserRepositoryImpl implements UserRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateUserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.openSession();
        List<User> users = session.createQuery("From User u").list();
        session.close();
        return users;
    }

    @Override
    public User findByID(long id) {
        Session session = sessionFactory.openSession();
        User user = session.find(User.class, id);
        session.close();
        return user;
    }

    @Override
    public User findByLogin(String login) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createQuery("FROM User u WHERE u.login = :login");
            query.setParameter("login", login);
            return (User) query.getSingleResult();
        } catch (Exception e) {
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public User save(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Long id = (Long) session.save(user);
            transaction.commit();
            return findByID(id);
        } catch (Exception e) {
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public User update(long id, User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            User existUser = session.find(User.class, id);
            if (existUser != null) {
                existUser.setName(user.getName());
                session.update(existUser);
                transaction.commit();
                return findByID(existUser.getId());
            }
            return  null;
        } catch (Exception e) {
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(findByID(id));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}