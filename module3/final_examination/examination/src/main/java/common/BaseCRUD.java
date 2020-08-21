package common;
import java.util.List;
import java.util.Optional;

public interface BaseCRUD<T> {
    Optional<T> get(int id);
    List<T> getAll();
    List<T> getAllWithPaging(Paging paging);
    int save(T t);
    int update(T t);
    int delete(String ids);
    int deleteCascade(String ids);
    List<T> search(String by, String val);
    List<T> searchWithPaging(String by, String val, Paging paging);
}
