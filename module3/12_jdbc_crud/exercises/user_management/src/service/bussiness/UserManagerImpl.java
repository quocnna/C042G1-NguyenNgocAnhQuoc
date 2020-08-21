package service.bussiness;

import model.User;
import service.dao.UserDAO;
import service.dao.UserDAOImpl;
import java.util.List;
import java.util.Optional;

public class UserManagerImpl implements UserManager<User> {
    UserDAO userDAO= new UserDAOImpl();
    @Override
    public Optional<User> get(int id) {
        return userDAO.get(id);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Override
    public List<User> searchByCountry(String country) {
        return userDAO.search(country);
    }
}
