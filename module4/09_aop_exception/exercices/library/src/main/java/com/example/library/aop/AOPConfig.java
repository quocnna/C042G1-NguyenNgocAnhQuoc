package com.example.library.aop;

import com.example.library.service.BookService;
import com.example.library.service.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AOPConfig {
    @Bean
    public BookService bookService(){ return new BookServiceImpl(); }

    @Bean
    public Logger logger(){ return  new Logger(); }
}
