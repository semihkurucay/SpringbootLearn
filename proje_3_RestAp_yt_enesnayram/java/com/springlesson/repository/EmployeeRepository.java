package com.springlesson.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springlesson.model.Employee;
import com.springlesson.model.UpdateEmployeeRequest;

@Repository
public class EmployeeRepository {
	@Autowired
	private List<Employee> employeeList;
	
	public List<Employee> getAllEmployeeList(){
		return employeeList;
	}
	
	public Employee getEmployeeById(String id) {
		//Employee findEmployee = null;
		
		for(Employee employee : getAllEmployeeList()) {
			if(employee.getId().equals(id)) {
				//findEmployee = employee;
				//break;
				return employee;
			}
		}
		
		//return findEmployee;
		return null;
	}
	
	public List<Employee> getEmployeeWithParams(String firstName, String lastName){
		List<Employee> employeeWithParams = new ArrayList<>();
		
		if(firstName == null && lastName == null) {
			return employeeList;
		}
		
		for(Employee employee : employeeList) {
			if(firstName != null && lastName != null) {
				if(employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)) {
					employeeWithParams.add(employee);
				}
			}else if(firstName != null && lastName == null) {
				if(employee.getFirstName().equalsIgnoreCase(firstName)) {
					employeeWithParams.add(employee);
				}
			}else if(firstName == null && lastName != null) {
				if(employee.getLastName().equalsIgnoreCase(lastName)) {
					employeeWithParams.add(employee);
				}
			}
		}
		
		return employeeWithParams;
	}
	
	public Employee saveEmployee(Employee newEmployee) {
		employeeList.add(newEmployee);
		return newEmployee;
	}
	
	public boolean deleteEmployee(String id) {
		return employeeList.remove(getEmployeeById(id));
	}
	
	public Employee updateEmployee(String id, UpdateEmployeeRequest updateEmployee) {
		if(deleteEmployee(id)) {
			Employee updatedEmployee = new Employee(id, updateEmployee.getFirstName(), updateEmployee.getLastName());
			employeeList.add(updatedEmployee);
			return updatedEmployee;
		}
		
		return null;
	}
}
