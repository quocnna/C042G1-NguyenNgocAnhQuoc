package com.example.examination.service;

import com.example.examination.model.Book;
import com.example.examination.model.Category;
import com.example.examination.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
        return bookRepository.findAllByDeletedIsFalse(pageable);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteByIds(int[] ids) {
        Arrays.stream(ids).forEach(e->bookRepository.deleteBook(e));
    }

    @Override
    public Page<Book> search(String by, String val, Pageable pageable) {
        if("All".equals(by) || val.isEmpty())
            return bookRepository.searchAll(val,pageable);

        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withMatcher("Category".equals(by)?"category.name":by.toLowerCase(),contains().ignoreCase());

        Book book = Book.builder().title(val).author(val).category(Category.builder().name(val).build()).build();
        return bookRepository.findAll(Example.of(book,matcher),pageable);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAllByDeletedIsFalse();
    }
}
