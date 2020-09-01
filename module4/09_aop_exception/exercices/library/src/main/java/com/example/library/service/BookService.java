package com.example.library.service;

import com.example.library.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> findById(int id) throws Exception;
    List<Book> findAll();
    void rent(Book book);
    void giveBack(Book book);
}
