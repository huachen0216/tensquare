package com.tensquare.qa;
import com.fathua.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class QaApp {

	public static void main(String[] args) {
		SpringApplication.run(QaApp.class, args);
		System.out.println("============QA startup===========");
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}
	
}
