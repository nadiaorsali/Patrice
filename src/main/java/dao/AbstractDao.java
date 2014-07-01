package dao;

import common.SessionHibernate;
import org.hibernate.classic.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Created by nicolas on 21/05/14.
 */
abstract class AbstractDao<T, PK extends Serializable> implements DAO<T, PK> {

    protected Session session = new SessionHibernate().getInstance();


    public T get(final Class<T> type, PK id) {
        org.hibernate.Transaction transaction = session.beginTransaction();
        return (T) session.get(type, id);
    }

    public T save(T obj) {
        org.hibernate.Transaction transaction = session.beginTransaction();
        session.save(obj);
        transaction.commit();
        return obj;
    }

    public T update(T obj) {
        org.hibernate.Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(obj);
        transaction.commit();
        return obj;
    }

    public List<T> list(final Class<T> type) {
        org.hibernate.Transaction transaction = session.beginTransaction();
        return session.createCriteria(type).list();
    }

    public void delete(T obj) {

        org.hibernate.Transaction transaction = session.beginTransaction();
        session.delete(obj);
        transaction.commit();
    }
}