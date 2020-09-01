package com.codegym.muon_sach.service;

import com.codegym.muon_sach.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(int id);

    boolean rentBook( Book book);

    void giveBookBack(Book book);
}
