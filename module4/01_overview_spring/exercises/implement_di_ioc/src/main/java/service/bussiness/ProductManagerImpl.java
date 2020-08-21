package service.bussiness;

import common.BaseCRUD;
import model.Product;

import java.util.List;
import java.util.Optional;

public class ProductManagerImpl implements ProductManager {

    private BaseCRUD<Product> ibase;
    public ProductManagerImpl(BaseCRUD<Product> ibase) {
        this.ibase= ibase;
    }


    @Override
    public Optional<Product> get(int id) {
        return ibase.get(id);
    }

    @Override
    public List<Product> getAll() {
        return ibase.getAll();
    }

    @Override
    public int save(Product product) {
        return ibase.save(product);
    }

    @Override
    public int update(Product product) {
        return ibase.update(product);
    }

    @Override
    public int delete(String ids) {
        return ibase.delete(ids);
    }
}
