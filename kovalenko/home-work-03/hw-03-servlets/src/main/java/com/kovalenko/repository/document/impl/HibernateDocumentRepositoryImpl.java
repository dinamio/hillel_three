package com.kovalenko.repository.document.impl;

import com.kovalenko.entity.document.Document;
import com.kovalenko.repository.document.DocumentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("hibernateDocumentRepositoryImpl")
public class HibernateDocumentRepositoryImpl implements DocumentRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateDocumentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Document> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("From Document d");
        List<Document> documents = query.list();
        session.close();
        return documents;
    }

    @Override
    public Document findByID(long id) {
        Session session = sessionFactory.openSession();
        Document document = session.find(Document.class, id);
        session.close();
        return document;
    }

    @Override
    public void save(Document document) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(document);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Document update(long id, Document document) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Document existDocument = session.find(Document.class, id);
            if (existDocument != null) {
                existDocument.setTitle(document.getTitle());
                existDocument.setDescription(document.getDescription());
                session.update(existDocument);
                transaction.commit();
                return findByID(existDocument.getId());
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
