package com.example.library.service;

import com.example.library.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {
    List<Book> bookList= new ArrayList<>();

    public BookServiceImpl(){
        bookList.add(new Book(1,"Java Core",3));
        bookList.add(new Book(2,"C Sharp First",3));
        bookList.add(new Book(3,"Spring MVC Step by step",3));
        bookList.add(new Book(4,"ASP.Net Advance",3));
        bookList.add(new Book(5,"Programing Mobile",3));
    }

    @Override
    public Optional<Book> findById(int id) throws Exception {
        int index = bookList.indexOf(Book.builder().id(id).build());
        if(index>=0)
        return Optional.ofNullable(bookList.get(index));
        throw new Exception();
    }

    @Override
    public List<Book> findAll() { return bookList; }

    @Override
    public void rent(Book book) {
        if(book.getAmount()>0)
            book.setAmount(book.getAmount()-1);
    }

    @Override
    public void giveBack(Book book) { book.setAmount(book.getAmount()+1); }
}
