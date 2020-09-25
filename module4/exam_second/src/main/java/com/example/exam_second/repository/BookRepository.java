package com.example.exam_second.repository;

import com.example.exam_second.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query(value = "SELECT b FROM Book b WHERE b.title like %?1% OR b.author like %?1% OR b.publishingDate like %?1% OR b.description like %?1% or b.price like %?1%")
    Page<Book> searchAll(String val, Pageable pageable);

    @Query(value = "SELECT b FROM Book b WHERE b.id = 100")
    Page<Book> searchTest(Pageable pageable);
}
