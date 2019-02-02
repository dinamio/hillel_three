package com.documents.dao.impl.hibernate;

import com.documents.dao.DocumentDao;
import com.documents.dao.UserDao;
import com.documents.entity.Document;
import com.documents.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("HibernateDocumentDao")
public class HibernateDocumentDao implements DocumentDao {
    @Autowired
    @Qualifier("HibernateUserDao")
    UserDao userDao;
    @Autowired
    SessionFactory sessionFactory;

    private static final String SELECT_ALL = "from Document";
    private static final String DELETE = "delete from Document where id=:id";

    public List<Document> selectAll() {
        Session session = sessionFactory.openSession();
        List<Document> documentList = session.createQuery(SELECT_ALL).list();
        session.close();
        return documentList;
    }

    public void insert(Document document) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(document);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        session.close();
    }

    public void deleteById(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query documentQuery = session.createQuery(DELETE);
            documentQuery.setInteger("id", id);
            documentQuery.executeUpdate();
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        session.close();
    }

    public void updateById(Document document) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(document);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        session.close();
    }
}