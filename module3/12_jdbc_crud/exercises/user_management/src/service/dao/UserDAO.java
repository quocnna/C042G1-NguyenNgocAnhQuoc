package service.dao;

import model.User;
import java.util.List;

public interface UserDAO extends BaseDAO<User> {
    List<User> search(String name);
}
