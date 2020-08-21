package common;

import java.util.List;
import java.util.Optional;

public interface BaseCRUD<T> {
    Optional<T> get(int id);
    List<T> getAll();
    int save(T t);
    int update(T t);
    int delete(String ids);
}
