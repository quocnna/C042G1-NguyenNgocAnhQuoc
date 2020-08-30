package com.codegym.service;

import java.util.List;

import com.codegym.model.Comment;



public interface CommentService {
    void save(Comment comment);

    List<Comment> getAll();

    Comment findById(Long id);
}
