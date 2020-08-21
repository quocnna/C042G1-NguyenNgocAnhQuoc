package service;

import model.User;

import java.util.List;

public interface GeneralService<T> {
    List<T> getAll();
    void save(T t);
    void update(T t);
    void delete(int id);
    List<User> search(String by,String value);
}
