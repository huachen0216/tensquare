package com.tensquare.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author huachen
 * @create 2019-01-23 10:21
 */

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class WebApp {
    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
        System.out.println("===========Web Start==============");
    }
}
