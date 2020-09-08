package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService extends BaseService<Blog> {
    Page<Blog> search(String by, String val, Pageable pageable);
}
