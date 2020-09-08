package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public ModelAndView getIndex(@PageableDefault(value = 5) Pageable pageable){
        Page<Blog> res= blogService.findAll(pageable);
        return new ModelAndView("index","res",res);
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id){
        Optional<Blog> optionalBlog= blogService.findById(id);
        return optionalBlog.isPresent()?new ModelAndView("single","res",optionalBlog.get()): new ModelAndView("error","res",null);
    }
}
