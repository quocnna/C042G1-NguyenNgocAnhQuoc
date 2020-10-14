package com.example.exam_second.service;

import com.example.exam_second.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> findById(int id);
    Page<Book> findAll(Pageable pageable);
    void save(Book t);
    void deleteByIds(int[] ids);
    Page<Book> search(String by, String val, Pageable pageable);
    List<Book> getAll();
}
