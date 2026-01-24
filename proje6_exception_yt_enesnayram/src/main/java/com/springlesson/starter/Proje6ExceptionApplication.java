package com.springlesson.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EntityScan(basePackages = {"com.springlesson"})
@EnableJpaRepositories(basePackages = {"com.springlesson"})
@ComponentScan(basePackages = {"com.springlesson"})
@SpringBootApplication
@EnableScheduling
public class Proje6ExceptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proje6ExceptionApplication.class, args);
	}

}
