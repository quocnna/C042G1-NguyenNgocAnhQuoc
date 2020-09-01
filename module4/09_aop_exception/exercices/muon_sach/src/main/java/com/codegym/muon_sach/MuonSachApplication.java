package com.codegym.muon_sach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class MuonSachApplication {

    public static void main(String[] args) {
        SpringApplication.run(MuonSachApplication.class, args);
    }

}
