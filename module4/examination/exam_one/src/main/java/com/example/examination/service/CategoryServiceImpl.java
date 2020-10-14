package com.example.examination.service;

import com.example.examination.model.Category;
import com.example.examination.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void deleteByIds(int[] ids) {

    }

    @Override
    public Page<Category> search(String by, String val, Pageable pageable) {
        return null;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAllByDeletedIsFalse();
    }
}
