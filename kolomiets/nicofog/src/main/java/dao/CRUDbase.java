package dao;

/**
 * Created by mihail on 11/9/18.
 */
public interface CRUDbase<T> {

    T add(T t);

    T getById(long id);

    T update(T t);

    boolean deleteById(long id);

}
