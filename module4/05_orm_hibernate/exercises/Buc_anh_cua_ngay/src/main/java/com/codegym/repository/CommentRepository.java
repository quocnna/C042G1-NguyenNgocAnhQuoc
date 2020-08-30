package com.codegym.repository;

import java.util.List;

import com.codegym.model.Comment;



public interface CommentRepository {
    void save(Comment comment);

    List<Comment> getAll();

    Comment findById(Long id);
}
