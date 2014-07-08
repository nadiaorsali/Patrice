package dao;

import common.SessionHibernate;
import org.hibernate.classic.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Created by nicolas on 21/05/14.
 */
abstract class AbstractDao<T, PK extends Serializable> implements DAO<T, PK> {


    public T get(final Class<T> type, PK id) {
        Session session = this.getSessionHibernate();
        org.hibernate.Transaction transaction = session.beginTransaction();
        T obj = null;
        try{
            System.out.println("Getting a " + type.getSimpleName() +"...");
            obj = (T) session.get(type, id);
        } catch (RuntimeException re) {
            System.out.println("Error during getting a " + type.getSimpleName() +" : "+ re);
        } finally {
            session.close();
        }
        return obj;
    }

    public T save(T obj) {
        Session session = this.getSessionHibernate();
        org.hibernate.Transaction transaction = session.beginTransaction();
        try{
            System.out.println("Saving a " + obj.getClass().getSimpleName()+"...");
            session.save(obj);
            transaction.commit();
        } catch (RuntimeException re) {
            System.out.println("Error during saving a " + obj.getClass().getSimpleName() +" : "+ re);
            transaction.rollback();
        } finally {
            session.close();
        }
        return obj;
    }

    public T update(T obj) {
        Session session = this.getSessionHibernate();
        org.hibernate.Transaction transaction = session.beginTransaction();
        try{
            System.out.println("Updating a " + obj.getClass().getSimpleName()+"...");
            session.saveOrUpdate(obj);
            transaction.commit();
        } catch (RuntimeException re) {
            System.out.println("Error during updating a " + obj.getClass().getSimpleName() + " : "+ re);
            transaction.rollback();
        } finally {
            session.close();
        }
        return obj;
    }

    public List<T> list(final Class<T> type) {
        List<T> list = null;
        Session session = this.getSessionHibernate();
        org.hibernate.Transaction transaction = session.beginTransaction();
        try{
            System.out.println("Getting a list of " + type.getClass().getSimpleName()+"...");
            list = session.createCriteria(type).list();
        } catch (RuntimeException re) {
            System.out.println("Error during getting a list of " + type.getClass().getSimpleName() + " : " + re);
        } finally {
            session.close();
        }
        return list;
    }

    public void delete(T obj) {

        Session session = this.getSessionHibernate();
        org.hibernate.Transaction transaction = session.beginTransaction();
        try{
            System.out.println("Deleting a "+ obj.getClass().getSimpleName()+"...");
            session.delete(obj);
            transaction.commit();
        } catch (RuntimeException re) {
            System.out.println("Error during deleting a " + obj.getClass().getSimpleName() + " : " + re);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    private Session getSessionHibernate() {
        SessionHibernate sessionHibernate = new SessionHibernate();
        sessionHibernate.init();
        Session session = sessionHibernate.getInstance();
        return session;
    }
}