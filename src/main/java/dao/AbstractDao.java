package dao;

import common.SessionHibernate;
import org.hibernate.classic.Session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolas on 21/05/14.
 */
abstract class AbstractDao<T, PK extends Serializable> implements DAO<T, PK> {


    public T get(final Class<T> type, PK id) {
        Session session = new SessionHibernate().getInstance();
        org.hibernate.Transaction transaction = session.beginTransaction();
        T obj = (T) session.get(type, id);
        session.close();
        return obj;
    }

    public T save(T obj) {
        Session session = new SessionHibernate().getInstance();
        org.hibernate.Transaction transaction = session.beginTransaction();
        session.save(obj);
        transaction.commit();
        session.close();
        return obj;
    }

    public T update(T obj) {
        Session session = new SessionHibernate().getInstance();
        org.hibernate.Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(obj);
        transaction.commit();
        session.close();
        return obj;
    }

    public List<T> list(final Class<T> type) {
        List<T> list = new ArrayList<>();
        Session session = new SessionHibernate().getInstance();
        org.hibernate.Transaction transaction = session.beginTransaction();
        list = session.createCriteria(type).list();
        session.close();
        return list;
    }

    public void delete(T obj) {

        Session session = new SessionHibernate().getInstance();
        org.hibernate.Transaction transaction = session.beginTransaction();
        session.delete(obj);
        transaction.commit();
        session.close();
    }
}