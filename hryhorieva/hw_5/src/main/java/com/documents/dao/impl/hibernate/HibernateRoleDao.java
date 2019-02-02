package com.documents.dao.impl.hibernate;

import com.documents.dao.RoleDao;
import com.documents.entity.Role;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("HibernateRoleDao")
public class HibernateRoleDao implements RoleDao {
    @Autowired
    SessionFactory sessionFactory;

    private static final String SELECT_BY_ROLE = "from Role r where r.role=:role";

    public Role getByRole(String roleName){
        Session session = sessionFactory.openSession();
        Query userQuery = session.createQuery(SELECT_BY_ROLE);
        userQuery.setString("role", roleName);
        List<Role> roles = userQuery.list();
        if(roles.size() == 0){
            return null;
        }
        Role role = roles.get(0);
        session.close();
        return role;
    }
}
