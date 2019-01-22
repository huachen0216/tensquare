package com.tensquare.friend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import util.JwtUtil;

/**
 * @author huachen
 * @create 2019-01-22 8:35
 */

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableDiscoveryClient
public class FriendApp {
    public static void main(String[] args) {
        SpringApplication.run(FriendApp.class, args);
        System.out.println("=============Friend Start=============");
    }

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }

}
