package com.springlesson.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.springlesson.entity.RootEntity;
import com.springlesson.services.IEmployeeServices;

@RequestMapping(path = "/rest/api/employee")
@RestController
public class EmployeeController extends RestBaseController implements IEmployeeController{
	@Autowired
	private IEmployeeServices employeeServices;
	
	@GetMapping(path = "/list")
	@Override
	public RootEntity<List<DtoEmployee>> getAllEmployee() {
		// TODO Auto-generated method stub
		return ok(employeeServices.getAllEmployee());
	}

	@GetMapping(path = "/list/{id}")
	@Override
	public RootEntity<DtoEmployee> getEmployeeById(@PathVariable(name = "id") Long employeeId) {
		// TODO Auto-generated method stub
		return ok(employeeServices.getEmployeeById(employeeId));
	}

	@PostMapping(path = "/save")
	@Override
	public RootEntity<DtoEmployee> saveEmployee(@RequestBody DtoEmployeeIU dtoEmployeeIU) {
		// TODO Auto-generated method stub
		return ok(employeeServices.saveEmployee(dtoEmployeeIU));
	}

	@PutMapping(path = "/update/{id}")
	@Override
	public RootEntity<DtoEmployee> updateEmployee(@PathVariable(name = "id") Long employeeId, @RequestBody DtoEmployeeIU dtoEmployeeIU) {
		// TODO Auto-generated method stub
		return ok(employeeServices.updateEmployee(employeeId, dtoEmployeeIU));
	}

	@DeleteMapping(path = "delete/{id}")
	@Override
	public void deleteEmployee(Long employeeId) {
		// TODO Auto-generated method stub
		employeeServices.deleteEmployee(employeeId);
	}

}
