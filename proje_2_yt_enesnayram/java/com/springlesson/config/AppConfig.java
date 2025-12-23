package com.springlesson.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springlesson.entity.User;
import com.springlesson.service.UserServices;

@Configuration
public class AppConfig {
	
	@Bean
	public UserServices userService() {
		UserServices userServices = new UserServices();
		List<User> userList = new ArrayList<>();
		
		userList.add(new User("Ali"));
		userList.add(new User("Veli"));
		
		userServices.setUserList(userList);
		
		return userServices;
	}
}
