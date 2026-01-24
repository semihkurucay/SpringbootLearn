package com.springlesson.proje6_exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springlesson.dto.DtoEmployee;
import com.springlesson.services.IEmployeeServices;
import com.springlesson.starter.Proje6ExceptionApplication;

@SpringBootTest(classes = {Proje6ExceptionApplication.class})
class Proje6ExceptionApplicationTests {
	@Autowired
	IEmployeeServices employeeServices;
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("beforeEach çalıştı");
	}
	
	@Test
	public void testGetEmployeeById() {
		DtoEmployee dtoEmployee = employeeServices.getEmployeeById(1l);
		assertNotNull(dtoEmployee);//null gelirse hata verir
		assertEquals(1, dtoEmployee.getId());//iki değerin eşitliğini kontrol ediyor
		System.out.println(dtoEmployee.getFullName());
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("afterEach çalıştı");
	}
}
