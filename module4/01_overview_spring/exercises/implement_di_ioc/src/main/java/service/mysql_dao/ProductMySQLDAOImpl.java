package service.mysql_dao;

import model.Product;

import java.util.List;
import java.util.Optional;

public class ProductMySQLDAOImpl implements ProductMySQLDAO {
    @Override
    public Optional<Product> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public int save(Product product) {
        System.out.println("my sql save");
        return 2;
    }

    @Override
    public int update(Product product) {
        return 0;
    }

    @Override
    public int delete(String ids) {
        return 0;
    }
}
