package business.serviceImplement;

import java.util.List;

public interface IGeneret <T, E> {
    boolean save(T t);
    void delete(E e);
    List<T> findAll();
    T findById(E e);
}
