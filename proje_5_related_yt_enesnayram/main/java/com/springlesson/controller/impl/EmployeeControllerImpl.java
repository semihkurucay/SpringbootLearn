package com.springlesson.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springlesson.controller.IEmployeeController;
import com.springlesson.dto.DtoEmployee;
import com.springlesson.dto.DtoEmployeeIU;
import com.springlesson.services.IEmployeeServices;

@RestController
@RequestMapping(path = "/rest/api/employee")
public class EmployeeControllerImpl implements IEmployeeController{
	@Autowired
	IEmployeeServices employeeServices;

	@GetMapping(path = "/list")
	@Override
	public List<DtoEmployee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeServices.getAllEmployee();
	}

	@GetMapping(path = "/list{id}")
	@Override
	public DtoEmployee getEmployeeById(@PathVariable(name = "id") Long employeeId) {
		// TODO Auto-generated method stub
		return employeeServices.getEmployeeById(employeeId);
	}

	@PostMapping(path = "/save")
	@Override
	public DtoEmployee saveEmployee(@RequestBody @Validated DtoEmployeeIU dtoEmployeeIU) {
		// TODO Auto-generated method stub
		return employeeServices.saveEmployee(dtoEmployeeIU);
	}

	@PutMapping(path = "/update/{id}")
	@Override
	public DtoEmployee updateEmployee(@PathVariable(name = "id") Long employeeId, @RequestBody @Validated DtoEmployeeIU dtoEmployeeIU) {
		// TODO Auto-generated method stub
		return employeeServices.updateEmployee(employeeId, dtoEmployeeIU);
	}

	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteEmployee(@PathVariable(name = "id") Long employeeId) {
		// TODO Auto-generated method stub
		employeeServices.deleteEmployee(employeeId);
	}
}
