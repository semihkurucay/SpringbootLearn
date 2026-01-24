package com.springlesson.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlesson.dto.DtoDepatment;
import com.springlesson.dto.DtoEmployee;
import com.springlesson.entity.Department;
import com.springlesson.entity.Employee;
import com.springlesson.repository.IEmployeeRepository;
import com.springlesson.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@Override
	public DtoEmployee findEmployeeById(Long id) {
		// TODO Auto-generated method stub
		Optional<Employee> optinalEmployee = employeeRepository.findById(id);
		if(optinalEmployee.isEmpty()) {
			return null;
		}
		
		Employee employee = optinalEmployee.get();
		DtoEmployee dtoEmployee = new DtoEmployee();
		BeanUtils.copyProperties(employee, dtoEmployee);
		
		Department department = employee.getDepartment();
		DtoDepatment dtoDepatment = new DtoDepatment();
		BeanUtils.copyProperties(department, dtoDepatment);
		
		dtoEmployee.setDepartment(dtoDepatment);
		return dtoEmployee;
	}

}
