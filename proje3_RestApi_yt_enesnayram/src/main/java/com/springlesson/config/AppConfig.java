package com.springlesson.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springlesson.model.Employee;

@Configuration
public class AppConfig {
	@Bean
	public List<Employee> employeeList(){
		List<Employee> employees = new ArrayList<>();
		
		employees.add(new Employee("111", "Ali", "Candan"));
		employees.add(new Employee("222", "Faruk", "Yaşamaz"));
		employees.add(new Employee("333", "Tarık", "Yılmaz"));
		employees.add(new Employee("444", "Yaşar", "Can"));
		employees.add(new Employee("555", "Yaşar", "Yaşamaz"));
		
		return employees;
	}
}
