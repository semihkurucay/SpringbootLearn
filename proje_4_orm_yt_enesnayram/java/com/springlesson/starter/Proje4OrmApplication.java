package com.springlesson.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.springlesson")
@EntityScan(basePackages = "com.springlesson")
@EnableJpaRepositories(basePackages = "com.springlesson")
@SpringBootApplication
public class Proje4OrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proje4OrmApplication.class, args);
	}

}
