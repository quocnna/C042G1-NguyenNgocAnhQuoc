package com.example.blog.service;

import com.example.blog.model.Category;
import java.util.List;

public interface CategoryService extends BaseService<Category> {
    List<Category> getAll();
}
