package com.example.product.dao;

import java.util.List;
import java.util.Optional;

public interface ProductDAO<T> {
    Optional<T> get(int id);
    List<T> getAll();
    int save(T t);
    int update(T t);
    int removeById(int id);
    List<T> search(String name);
}
