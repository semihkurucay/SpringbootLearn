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
public class Proje7JwtSecurityApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(Proje7JwtSecurityApplicationStarter.class, args);
	}

}
