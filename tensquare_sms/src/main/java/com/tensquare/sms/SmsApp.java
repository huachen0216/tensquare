package com.tensquare.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author huachen
 * @create 2019-01-18 9:53
 */

@SpringBootApplication
public class SmsApp {
    public static void main(String[] args) {
        SpringApplication.run(SmsApp.class, args);
        System.out.println("===============Sms Start====================");
    }



}
