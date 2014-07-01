package dao;

import java.io.Serializable;

/**
 * Created by nicolas on 04/06/14.
 */
public interface DAO<T, PK extends Serializable> {
    public T find(final Class<T> type, PK id);
    public T save(T obj);
    public T update(T obj);
    public java.util.List<T> list(final Class<T> type);
    public void delete(T obj);
}
