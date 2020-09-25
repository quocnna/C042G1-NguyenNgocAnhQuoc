package com.example.examination.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
    Optional<T> findById(int id);
    Page<T> findAll(Pageable pageable);
    void save(T t);
    void deleteByIds(int[] ids);
    Page<T> search(String by, String val, Pageable pageable);
    List<T> getAll();
}
