package service.bussiness;

import common.Paging;
import java.util.List;
import java.util.Optional;

public interface BaseManager<T> {
    Optional<T> get(int id);
    List<T> getAll();
    List<T> getAllWithPaging(Paging paging);
    void save(T t);
    void update(T t);
    void delete(String ids);
    void deleteCascade(String ids);
    List<T> search(String by, String val);
    List<T> searchWithPaging(String by, String val, Paging paging);
}
