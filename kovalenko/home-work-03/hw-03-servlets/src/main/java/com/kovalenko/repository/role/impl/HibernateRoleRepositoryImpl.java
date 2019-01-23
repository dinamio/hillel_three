package com.kovalenko.repository.role.impl;

import com.kovalenko.entity.user.role.Role;
import com.kovalenko.entity.user.role.RoleType;
import com.kovalenko.repository.role.RoleRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateRoleRepositoryImpl implements RoleRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateRoleRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Role findByRoleType(RoleType roleType) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createQuery("From Role r WHERE r.roleName = :roleType");
            query.setParameter("roleType", roleType.getRoleName());
            return (Role) query.getSingleResult();
        } catch (Exception e) {
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }
}
