package com.tensquare.manger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import util.JwtUtil;

/**
 * @author huachen
 * @create 2019-01-23 8:59
 */

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ManagerApp {
    public static void main(String[] args) {
        SpringApplication.run(ManagerApp.class, args);
        System.out.println("=============Manager Start============");
    }

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }
}
