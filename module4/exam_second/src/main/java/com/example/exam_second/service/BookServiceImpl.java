package com.example.exam_second.service;

import com.example.exam_second.common.StringUtil;
import com.example.exam_second.model.Book;
import com.example.exam_second.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Optional<Book> findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public void save(Book t) {
        bookRepository.save(t);
    }

    @Override
    public void deleteByIds(int[] ids) {
        Arrays.stream(ids).forEach(e->bookRepository.deleteById(e));
    }

    @Override
    public Page<Book> search(String by, String val, Pageable pageable) {
        LocalDate localDate= LocalDate.now();
        if("All".equals(by) || val.isEmpty())
            return bookRepository.searchAll(val,pageable);

        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withMatcher(by.toLowerCase(),contains().ignoreCase());

        if("Publishing Date".equals(by)){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try{
                localDate = LocalDate.parse(val, formatter);
            }
            catch (Exception e){
              return  bookRepository.searchTest(pageable);
            }
        }

        Book book =  Book.builder().title(val).description(val).author(val).price(StringUtil.parseIntegerOrDefault(val))
                .publishingDate(localDate).build();
        return bookRepository.findAll(Example.of(book,matcher),pageable);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
