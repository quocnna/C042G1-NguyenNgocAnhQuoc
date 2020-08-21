package bussiness;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import model.Product;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService<Product> {
    private static ProductDAO<Product> productDAO= new ProductDAOImpl();
    @Override
    public Optional<Product> get(int id) {
        return productDAO.get(id);
    }

    @Override
    public List<Product> getAll() {
        return productDAO.getAll();
    }

    @Override
    public void save(Product product) {
        productDAO.save(product);
    }

    @Override
    public void update(Product product) {
        productDAO.update(product);
    }

    @Override
    public void removeById(int id) {
        productDAO.removeById(id);
    }

    @Override
    public List<Product> search(String name) {
        return productDAO.search(name);
    }
}
