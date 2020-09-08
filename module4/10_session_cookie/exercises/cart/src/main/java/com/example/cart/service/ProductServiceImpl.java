package com.example.cart.service;

import com.example.cart.model.Products;
import com.example.cart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Optional<Products> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Products> findAll() {
        return productRepository.findAll();
    }
}
