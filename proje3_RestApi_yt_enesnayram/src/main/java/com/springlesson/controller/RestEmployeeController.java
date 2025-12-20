package com.springlesson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springlesson.model.Employee;
import com.springlesson.model.UpdateEmployeeRequest;
import com.springlesson.services.EmployeeService;


@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(path = "/list")
	public List<Employee> getAllEmployeeList(){
		return employeeService.getAllEmployeeList();
	}
	
	@GetMapping(path = "list/{id}")
	public Employee getEmployeeById(@PathVariable(name = "id", required = true) String id) {
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping(path = "/with-params")
	public List<Employee> getEmployeeWithParams(@RequestParam(name = "firstName", required = false) String firstName,
												@RequestParam(name = "lastName", required = false) String lastName){
		return employeeService.getEmployeeWithParams(firstName, lastName);
	}
	
	@PostMapping(path = "/save-employee")
	public Employee saveEmployee(@RequestBody Employee newEmployee) {
		return employeeService.saveEmployee(newEmployee);
	}
	
	@DeleteMapping("/delete-employee/{id}")
	public boolean deleteEmployee(@PathVariable(name = "id", required = true) String id) {
		return employeeService.deleteEmployee(id);
	}
	
	@PutMapping("/update-employe/{id}")
	public Employee updateEmployee(@PathVariable(name = "id", required = true) String id, @RequestBody UpdateEmployeeRequest updateEmployee){
		return employeeService.updateEmployee(id, updateEmployee);
	}
}
