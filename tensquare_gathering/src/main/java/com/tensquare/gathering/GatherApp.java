package com.tensquare.gathering;

import com.fathua.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
@EnableCaching
public class GatherApp {

	public static void main(String[] args) {
		SpringApplication.run(GatherApp.class, args);
		System.out.println("===========Gather Startup=============");
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}
	
}
