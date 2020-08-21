package service.sqloracle_dao;

import model.Product;

import java.util.List;
import java.util.Optional;

public class ProductSQLOracleDAOImpl implements  ProductSQLOracleDAO {
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
        System.out.println("sql oracle save");
        return 1;
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
