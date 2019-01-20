package com.tensquare.spit;

import util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpitApp {
    public static void main(String[] args) {
        SpringApplication.run(SpitApp.class, args);
        System.out.println("==========SpritApp Startup=============");
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }

}
