package dao.impl;

import config.HibernateUtil;
import dao.GenreDao;
import model.Genre;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by eugen on 11/3/17.
 */
public class GenreDaoImpl implements GenreDao {
    public Integer insert(Genre genre) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Integer id = (Integer) session.save(genre);
        transaction.commit();
        return id;
    }

    public Genre findById(Integer id) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Genre genre = (Genre) HibernateUtil.getSession().get(Genre.class, id);
        transaction.commit();
        return genre;
    }
}
