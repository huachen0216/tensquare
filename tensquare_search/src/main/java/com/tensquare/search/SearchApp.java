package com.tensquare.search;

import util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author huachen
 * @create 2019-01-16 9:18
 */

@SpringBootApplication
public class SearchApp {

    public static void main(String[] args) {
        SpringApplication.run(SearchApp.class, args);
        System.out.println("=============Search Startup==============");
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }
}
