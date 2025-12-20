package com.springlesson.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springlesson.config.AppConfig;
import com.springlesson.entity.User;
import com.springlesson.service.LoginServices;
import com.springlesson.service.UserServices;

public class main {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserServices userServices = context.getBean(UserServices.class);
		
		for(User user : userServices.getUserList()) {
			System.out.println(user.getName());
		}
		
		LoginServices loginServices = new LoginServices();
		loginServices.login();
	}
}
