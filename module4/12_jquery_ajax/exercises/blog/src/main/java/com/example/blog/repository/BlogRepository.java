package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "SELECT b FROM Blog b WHERE b.title like %?1% OR b.content like %?1% or b.likes like %?1% or b.category.name like %?1%")
    Page<Blog> searchAll(String val, Pageable pageable);
}
