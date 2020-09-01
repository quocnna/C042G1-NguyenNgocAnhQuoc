package com.codegym.muon_sach.service.impl;

import com.codegym.muon_sach.model.Book;
import com.codegym.muon_sach.service.BookService;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.ArrayUtils;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {
    private static Map<Integer,Book> books=new HashMap<>();

    static {
        books.put(0,new Book(0,"Codegym",5));
        books.put(1,new Book(1,"Quang Nam than thuong",3));
        books.put(2,new Book(2,"Da Nang men yeu",2));
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<Book>(books.values());
    }

    @Override
    public Book getBookById(int id) {
        Book book=books.get(id);
        if(book!=null) {
            return book;
        }
        return null;
    }

    @Override
    public boolean rentBook(Book book) {
        Book temp=books.get(book.getId());
        if(temp.getAmount()==0) {
            return false;
        } else {
            temp.setAmount(temp.getAmount()-1);
//            books.replace(book.getId(), book);
            return true;
        }
    }

    @Override
    public void giveBookBack(Book book) {
        Book temp=books.get(book.getId());
        if(temp!=null) {
            temp.setAmount(temp.getAmount()+1);
        }
    }
}
