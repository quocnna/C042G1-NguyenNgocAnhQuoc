package dao;

import model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDAO<T> {
    Optional<T> get(int id);
    List<T> getAll();
    void save(T t);
    void update(T t);
    void removeById(int id);
    List<T> search(String name);
}
