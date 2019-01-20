package com.tensquare.recruit;
import util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RecruitApp {

	public static void main(String[] args) {
		SpringApplication.run(RecruitApp.class, args);
		System.out.println("=============RecruitApp startup===============");
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}
	
}
