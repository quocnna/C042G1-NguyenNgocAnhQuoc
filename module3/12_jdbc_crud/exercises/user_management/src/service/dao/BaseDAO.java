package service.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BaseDAO<T> {
    Optional<T> get(int id);
    List<T> getAll();
    void save(T t);
    void update(T t);
    void delete(int id);
}
