package com.example.exam_second.repository;

import com.example.exam_second.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "SELECT b FROM Product b WHERE b.name like %?1% OR b.startPrice like %?1% or b.category.name like %?1%")
    Page<Product> searchAll(String val, Pageable pageable);
}
