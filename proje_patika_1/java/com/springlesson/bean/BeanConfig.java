package com.springlesson.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.springlesson.dto.BeanDto;

@Configuration
public class BeanConfig {
	@Bean(initMethod = "initialBeanMethod", destroyMethod = "destroyBeanMethod")
	@Scope("singleton")
	public BeanDto beanDto() {
		return BeanDto.builder()
				.id(0l)
				.name("name is name")
				.beanData("data is data")
				.build();
	}
}
