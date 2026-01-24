package com.springlesson.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.springlesson")
@ComponentScan(basePackages = "com.springlesson")
@EnableJpaRepositories(basePackages = "com.springlesson")
@SpringBootApplication
public class Proje8PageableApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(Proje8PageableApplicationStarter.class, args);
	}

}
