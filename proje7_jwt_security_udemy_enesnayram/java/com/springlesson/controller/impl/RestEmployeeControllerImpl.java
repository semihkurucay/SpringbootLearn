package com.springlesson.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springlesson.controller.IRestEmployeeController;
import com.springlesson.dto.DtoEmployee;
import com.springlesson.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class RestEmployeeControllerImpl implements IRestEmployeeController {
	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping("/{id}")
	@Override
	public DtoEmployee findEmployeeById(/*@Valid @NotEmpty*/ @PathVariable(value = "id") Long id) {
		// TODO Auto-generated method stub
		return employeeService.findEmployeeById(id);
	}

}
