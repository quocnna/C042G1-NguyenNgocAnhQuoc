package com.codegym.service.impl;

import com.codegym.model.Comment;
import com.codegym.repository.CommentRepository;
import com.codegym.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.getAll();
    }

    @Override
    public Comment findById(Long id) {
        Comment comment = commentRepository.findById(id);
        return comment;
    }
}
