package com.tensquare.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author huachen
 * @create 2019-01-17 9:06
 */

@SpringBootApplication
public class RabbitApp {
    public static void main(String[] args) {
        SpringApplication.run(RabbitApp.class, args);
        System.out.println("==========Rabbit Start============");
    }
}
