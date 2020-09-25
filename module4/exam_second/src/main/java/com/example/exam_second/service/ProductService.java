package com.example.exam_second.service;

import com.example.exam_second.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> findById(int id);
    Page<Product> findAll(Pageable pageable);
    void save(Product t);
    void deleteByIds(int[] ids);
    Page<Product> search(String by, String val, Pageable pageable);
    List<Product> getAll();
}
