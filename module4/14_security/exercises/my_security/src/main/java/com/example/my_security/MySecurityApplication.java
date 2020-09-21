package com.example.my_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MySecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySecurityApplication.class, args);
    }

}
