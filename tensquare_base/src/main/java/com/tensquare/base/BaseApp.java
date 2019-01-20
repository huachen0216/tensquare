package com.tensquare.base;

import util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author huachen
 * @create 2018-12-08 18:34
 */
@SpringBootApplication
public class BaseApp {
    public static void main(String[] args) {
        SpringApplication.run(BaseApp.class, args);
        System.out.println("_______BaseAPP start_________");
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1,1);
    }

}

