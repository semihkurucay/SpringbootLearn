package com.springlesson.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.springlesson.dto.DtoDepartment;
import com.springlesson.dto.DtoEmployee;
import com.springlesson.dto.DtoEmployeeIU;
import com.springlesson.entites.Department;
import com.springlesson.entites.Employee;
import com.springlesson.repository.IDepartmentRepository;
import com.springlesson.repository.IEmployeeRepository;
import com.springlesson.services.IEmployeeServices;

@Service
public class EmployeeServicessImpl implements IEmployeeServices{
	@Autowired
	IEmployeeRepository employeeRepository;
	
	@Autowired
	IDepartmentRepository departmentRepository;
	
	@Override
	public List<DtoEmployee> getAllEmployee() {
		// TODO Auto-generated method stub
		List<DtoEmployee> dtoEmployeeList = new ArrayList<>();
		
		for(Employee employee : employeeRepository.findAll()) {
			DtoEmployee dtoEmployee = new DtoEmployee();
			BeanUtils.copyProperties(employee, dtoEmployee);
			
			Department department = employee.getDepartment();
			if(department != null) {
				DtoDepartment dtoDepartment = new DtoDepartment();
				BeanUtils.copyProperties(department, dtoDepartment);
				dtoEmployee.setDtoDepartment(dtoDepartment);
			}
			
			dtoEmployeeList.add(dtoEmployee);
		}
		
		return dtoEmployeeList;
	}

	@Override
	public DtoEmployee getEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
		Optional<Employee> optional = employeeRepository.findById(employeeId);
		
		if(optional.isPresent()) {
			Employee employee = optional.get();
			DtoEmployee dtoEmployee = new DtoEmployee();
			BeanUtils.copyProperties(employee, dtoEmployee);
			
			Department department = employee.getDepartment();
			if(department != null) {
				DtoDepartment dtoDepartment = new DtoDepartment();
				BeanUtils.copyProperties(department, dtoDepartment);
				dtoEmployee.setDtoDepartment(dtoDepartment);
			}
			
			return dtoEmployee;
		}
		
		return null;
	}

	@Override
	public DtoEmployee saveEmployee(DtoEmployeeIU dtoEmployeeIU) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		BeanUtils.copyProperties(dtoEmployeeIU, employee);
		
		Long departmentId = dtoEmployeeIU.getDepartmentId();
		if(departmentId != null) {
			Optional<Department> optional = departmentRepository.findById(departmentId);
			if(optional.isPresent()) {
				employee.setDepartment(optional.get());
			}else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bu ID'ye sahip bir Departman bulunmamaktadır!");
			}
		}else {
			employee.setDepartment(null);
		}

		return getEmployeeById(employeeRepository.save(employee).getId());
	}

	@Override
	public DtoEmployee updateEmployee(Long employeeId, DtoEmployeeIU dtoEmployeeIU) {
		// TODO Auto-generated method stub
		Optional<Employee> optional = employeeRepository.findById(employeeId);
		if(optional.isPresent()) {
			Employee employee = optional.get();
			employee.setFirstName(dtoEmployeeIU.getFirstName());
			employee.setLastName(dtoEmployeeIU.getLastName());
			
			Long departmentId = dtoEmployeeIU.getDepartmentId();
			if(departmentId != null) {
				Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
				if(optionalDepartment.isPresent()) {
					employee.setDepartment(optionalDepartment.get());
				}else {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bu ID'ye sahip bir Departman bulunmamaktadır!");
				}
			}else {
				employee.setDepartment(null);
			}
			
			
			return getEmployeeById(employeeRepository.save(employee).getId());
		}
		return null;
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		// TODO Auto-generated method stub
		Optional<Employee> optional = employeeRepository.findById(employeeId);
		if(optional.isPresent()) {
			Employee employee = optional.get();
			employeeRepository.delete(employee);
		}
	}

}
