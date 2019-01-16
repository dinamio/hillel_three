package com.hillel.test.dao.impl;

import com.hillel.test.dao.ServerDao;
import com.hillel.test.model.Server;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by eugen on 11/21/17.
 */
public class ServerDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void save(Server server) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(server);
        tx.commit();
        session.close();
    }

    public List<Server> findAll() {
        Session session = this.sessionFactory.openSession();
        return session.createCriteria(Server.class).list();
    }

    public Server findById(Integer id) {
        Session session = this.sessionFactory.openSession();
        return (Server) session.get(Server.class, id);
    }

    public void delete(Server server) {

    }

    public void update(Server server) {

    }
}
