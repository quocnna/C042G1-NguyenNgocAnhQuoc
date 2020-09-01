package com.example.library.controller;


import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class BookController {
    private Map<Integer,Book> bookMap=new HashMap<>();
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String getIndex(){ return "index"; }

    @GetMapping("/giveBack")
    public String getGiveBack(){ return "giveBack"; }

    @GetMapping("/books")
    public ModelAndView getBooks(){ return new ModelAndView("rent","res",bookService.findAll()); }

    @GetMapping("/rent/{id}")
    public String rent(@PathVariable int id) throws Exception{
        Book book= bookService.findById(id).get();
        bookService.rent(book);
        bookMap.put(new Random().nextInt(100),book);
        return "redirect:/books";
    }

    @PostMapping("/giveBack")
    public String giveBack(@RequestParam int codeRent) throws Exception{
        Book book= bookMap.get(codeRent);
        if(book!=null){
            bookService.giveBack(book);
            return "redirect:/books";
        }
        throw new Exception();
    }

    @ExceptionHandler(Exception.class)
    public String showErrorPage(){
        return "error";
    }
}
