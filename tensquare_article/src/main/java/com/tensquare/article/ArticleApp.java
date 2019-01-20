package com.tensquare.article;

import util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class ArticleApp {

	public static void main(String[] args) {
		SpringApplication.run(ArticleApp.class, args);
		System.out.println("============article start=================");
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}
	
}
