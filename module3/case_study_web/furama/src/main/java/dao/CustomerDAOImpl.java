package dao;

import common.Paging;
import model.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public Optional<Customer> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public List<Customer> getAllWithPaging(Paging paging) {
        return null;
    }

    @Override
    public boolean save(Customer customer) {
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public boolean delete(String ids) {
        return false;
    }

    @Override
    public boolean deleteCascade(String ids) {
        return false;
    }

    @Override
    public List<Customer> search(String by, String val) {
        return null;
    }

    @Override
    public List<Customer> searchWithPaging(String by, String val, Paging paging) {
        return null;
    }
}
