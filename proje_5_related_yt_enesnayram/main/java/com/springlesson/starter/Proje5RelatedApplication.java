package com.springlesson.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.springlesson.configration.GlobalProperties;

@ComponentScan("com.springlesson")
@EntityScan("com.springlesson")
@EnableJpaRepositories(basePackages = "com.springlesson")
@SpringBootApplication
@EnableConfigurationProperties(value = GlobalProperties.class)
public class Proje5RelatedApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proje5RelatedApplication.class, args);
	}

}
