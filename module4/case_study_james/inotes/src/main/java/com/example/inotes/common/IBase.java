package com.example.inotes.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IBase<T> {
    Optional<T> findById(int id);
    Page<T> findAll(Pageable pageable);
    void save(T t);
    void deleteByIds(int[] ids);
    Page<T> search(String by, String val, Pageable pageable);
    List<T> getAll();
}
