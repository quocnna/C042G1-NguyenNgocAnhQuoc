package service.bussiness;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserManager<T> {
    Optional<T> get(int id);
    List<T> getAll() throws SQLException;
    void save(T t);
    void update(T t);
    void delete(int id);
    List<T> searchByCountry(String country);
}
