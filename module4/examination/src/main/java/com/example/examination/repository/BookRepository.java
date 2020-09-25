package com.example.examination.repository;

import com.example.examination.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findAllByDeletedIsFalse();
    Page<Book> findAllByDeletedIsFalse(Pageable pageable);
    @Query(value = "SELECT b FROM Book b WHERE (b.title like %?1% OR b.author like %?1% or b.category.name like %?1%) and b.deleted=0")
    Page<Book> searchAll(String val, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value="update book set deleted = 1 where id= ?;",nativeQuery = true)
    int deleteBook(int id);
}
