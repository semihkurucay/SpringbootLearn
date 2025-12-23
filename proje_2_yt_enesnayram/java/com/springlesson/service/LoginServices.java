package com.springlesson.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springlesson.config.AppConfig;

public class LoginServices {
	public void login() {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserServices userServices = context.getBean(UserServices.class);
	}
}
