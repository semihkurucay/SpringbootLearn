package com.springlesson.proje_patika_1Starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.springlesson")
@SpringBootApplication
public class ProjePatika1ApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(ProjePatika1ApplicationStarter.class, args);
	}

}
