package com.codegym.controller;

import com.codegym.model.Comment;
import com.codegym.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/image")
    public ModelAndView showEdit() {
        return new ModelAndView("image");
    }

    @GetMapping("/create-comment")
    public ModelAndView showCreateComment() {
        return new ModelAndView("create-comment","comment",new Comment());
    }

    @PostMapping("/create-comment")
    public ModelAndView saveComment(@ModelAttribute("comment") Comment comment) {
        commentService.save(comment);
        return new ModelAndView("list-comment");
    }

    @GetMapping("/list-comment")
    public ModelAndView getListComment() {
        return new ModelAndView("list-comment","comments",commentService.getAll());
    }

    @GetMapping("/update-like/{id}")
    public ModelAndView updateLike(@PathVariable("id") Long id) {
        Comment comment = commentService.findById(id);
        comment.setTotalLike(comment.getTotalLike()+1);
        commentService.save(comment);
        return new ModelAndView("list-comment","comments",commentService.getAll());
    }

}
