package com.tensquare.base;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author huachen
 * @create 2018-12-08 18:34
 */
@SpringBootApplication
@EnableEurekaClient
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

