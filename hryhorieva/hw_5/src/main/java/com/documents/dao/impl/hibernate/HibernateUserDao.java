package com.documents.dao.impl.hibernate;

import com.documents.dao.UserDao;
import com.documents.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("HibernateUserDao")
public class HibernateUserDao implements UserDao {
    @Autowired
    SessionFactory sessionFactory;


    private static final String SELECT_ALL = "from User";
    private static final String SELECT_BY_LOGIN_AND_PASSWORD = "from User u where u.login=:login and u.password=:password";
    private static final String SELECT_BY_LOGIN = "from User u where u.login=:login";
    private static final String DELETE = "delete from User where id=:id";


    public List<User> selectAll() {
        Session session = sessionFactory.openSession();
        List<User> UserList = session.createQuery(SELECT_ALL).list();
        session.close();
        return UserList;
    }

    public User getByLoginAndPassword(String login, String password){
        Session session = sessionFactory.openSession();
        Query userQuery = session.createQuery(SELECT_BY_LOGIN_AND_PASSWORD);
        userQuery.setString("login", login);
        userQuery.setString("password", password);
        List<User> users = userQuery.list();
        if(users.size() == 0){
            return null;
        }
        User user = users.get(0);
        session.close();
        return user;
    }

    public User getByLogin(String login){
        Session session = sessionFactory.openSession();
        Query userQuery = session.createQuery(SELECT_BY_LOGIN);
        userQuery.setString("login", login);
        List<User>users = userQuery.list();
        if(users.size() == 0){
            return null;
        }
        User user = users.get(0);
        session.close();
        return user;
    }

    public User getById(Integer id){
        Session session = sessionFactory.openSession();
        User user = (User)session.get(User.class, id);
        session.close();
        return user;
    }


    public void insert(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }


    public void deleteById(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query userQuery = session.createQuery(DELETE);
            userQuery.setInteger("id", id);
            userQuery.executeUpdate();
            session.delete(id);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        session.close();
    }

    public void updateById(User user) {

    }

    protected Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

}