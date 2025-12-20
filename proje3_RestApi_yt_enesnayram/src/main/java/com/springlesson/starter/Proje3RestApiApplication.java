package com.springlesson.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.springlesson"})
@SpringBootApplication
public class Proje3RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proje3RestApiApplication.class, args);
	}

}
