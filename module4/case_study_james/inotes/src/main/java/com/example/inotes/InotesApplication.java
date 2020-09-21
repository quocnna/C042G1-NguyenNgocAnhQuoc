package com.example.inotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories("com.example.inotes.service.dao")
@EntityScan("com.example.inotes.model")
public class InotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(InotesApplication.class, args);
    }

}
