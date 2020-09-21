package com.example.inotes.common;


import com.example.inotes.service.NoteService;
import com.example.inotes.service.NoteServiceImpl;
import com.example.inotes.service.bussiness.NoteManagerDBImpl;
import com.example.inotes.service.bussiness.NoteTypeManager;
import com.example.inotes.service.bussiness.NoteTypeManagerImpl;
import com.example.inotes.service.dao.NoteDAOImpl;
import com.example.inotes.service.dao.NoteTypeDAOImpl;
import com.example.inotes.service.file.NoteFileImpl;
import com.example.inotes.service.file.NoteTypeFileImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.example.inotes")
//@EnableJpaRepositories("com.example.inotes.service.dao")
//@EntityScan("com.example.inotes.model")
public class AppConfig {

        @Bean
    @Qualifier("db")
    public NoteService noteService() {
        return  new NoteServiceImpl(new NoteManagerDBImpl(new NoteDAOImpl()));
    }

//    @Bean
//    @Qualifier("file")
//    public NoteManager noteManager() {
//        return new NoteManagerImpl(new NoteFileImpl());
//    }
//
//    @Bean
//    @Qualifier("db")
//    public NoteManager noteDB() {
//        return new NoteManagerImpl(new NoteDAOImpl());
//    }
//
//    @Bean
//    @Qualifier("file")
//    public NoteTypeManager noteTypFile() {
//        return new NoteTypeManagerImpl(new NoteTypeFileImpl());
//    }
//
//    @Bean
//    @Qualifier("db")
//    public NoteTypeManager noteTypeDB() {
//        return new NoteTypeManagerImpl(new NoteTypeDAOImpl());
//    }
}
