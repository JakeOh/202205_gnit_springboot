package com.example.mybootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MybootappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybootappApplication.class, args);
	}

}
