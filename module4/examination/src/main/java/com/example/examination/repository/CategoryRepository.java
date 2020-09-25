package com.example.examination.repository;

import com.example.examination.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findAllByDeletedIsFalse();
}
