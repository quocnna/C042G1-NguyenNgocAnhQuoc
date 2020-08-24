package com.example.product.dao;

import com.example.product.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductDAOImpl implements ProductDAO<Product> {
    private List<Product> products = new ArrayList<>();

    public ProductDAOImpl() {
        products.add(new Product(1, "nokia lumia", "usa", 800, true, "microsoft", "phone"));
        products.add(new Product(2, "iphone 12", "usa", 1500, true, "apple", "phone"));
        products.add(new Product(3, "galaxy A500", "korea", 500, true, "samsung", "phone"));
        products.add(new Product(4, "5D mark 4", "japan", 2000, true, "canon", "camera digital"));
        products.add(new Product(5, "FS 6D234", "China", 1500, false, "LG", "television"));
    }

    @Override
    public Optional<Product> get(int id) {
        int index = products.indexOf(new Product(id));
        return Optional.ofNullable(products.get(index));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public int save(Product product) {
        products.add(product);
        return 1;
    }

    @Override
    public int update(Product product) {
        int index = products.indexOf(new Product(product.getId()));
        if (index >= 0){
            products.set(index, product);
            return 1;
        }
        return 0;
    }

    @Override
    public int removeById(int id) {
        int index = products.indexOf(new Product(id));
        if (index >= 0){
            products.remove(index);
            return 1;
        }
        return 0;
    }

    @Override
    public List<Product> search(String name) {
        List<Product> res= products.stream().filter(i->i.getBrandName().contains(name)).collect(Collectors.toList());
        return res;

    }
}
