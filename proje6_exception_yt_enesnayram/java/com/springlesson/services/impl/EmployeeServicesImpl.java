package com.springlesson.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlesson.dto.DtoDepartment;
import com.springlesson.dto.DtoEmployee;
import com.springlesson.dto.DtoEmployeeIU;
import com.springlesson.entity.Department;
import com.springlesson.entity.Employee;
import com.springlesson.exception.BaseException;
import com.springlesson.exception.ErrorMessage;
import com.springlesson.exception.MessageType;
import com.springlesson.repository.IDepartmentRepository;
import com.springlesson.repository.IEmployeeRepository;
import com.springlesson.services.IEmployeeServices;

@Service
public class EmployeeServicesImpl implements IEmployeeServices {
	@Autowired
	private IEmployeeRepository employeeRepository;

	@Autowired
	private IDepartmentRepository departmentRepository;

	@Override
	public List<DtoEmployee> getAllEmployee() {
		// TODO Auto-generated method stub
		List<DtoEmployee> dtoEmployeeList = new ArrayList<>();

		List<Employee> employeeList = employeeRepository.findAll();
		for (Employee employee : employeeList) {
			DtoEmployee dtoEmployee = new DtoEmployee();
			BeanUtils.copyProperties(employee, dtoEmployee);

			Department department = employee.getDepartment();
			DtoDepartment dtoDepartment = new DtoDepartment();
			BeanUtils.copyProperties(department, dtoDepartment);

			dtoEmployee.setDepartment(dtoDepartment);
			dtoEmployeeList.add(dtoEmployee);
		}

		return dtoEmployeeList;
	}

	@Override
	public DtoEmployee getEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
		Optional<Employee> optional = employeeRepository.findById(employeeId);
		if (optional.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, employeeId.toString()));
		}

		Employee employee = optional.get();
		DtoEmployee dtoEmployee = new DtoEmployee();
		BeanUtils.copyProperties(employee, dtoEmployee);

		Department department = employee.getDepartment();
		DtoDepartment dtoDepartment = new DtoDepartment();
		BeanUtils.copyProperties(department, dtoDepartment);

		dtoEmployee.setDepartment(dtoDepartment);
		return dtoEmployee;

	}

	@Override
	public DtoEmployee saveEmployee(DtoEmployeeIU dtoEmployeeIU) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		BeanUtils.copyProperties(dtoEmployeeIU, employee);

		if (dtoEmployeeIU.getDepartmentId() == null) {
			employee.setDepartment(null);
		} else {
			Optional<Department> optionalDepartment = departmentRepository.findById(dtoEmployeeIU.getDepartmentId());
			if (optionalDepartment.isPresent()) {
				Department department = optionalDepartment.get();
				employee.setDepartment(department);
			}
		}

		return getEmployeeById(employeeRepository.save(employee).getId());
	}

	@Override
	public DtoEmployee updateEmployee(Long employeeId, DtoEmployeeIU dtoEmployeeIU) {
		// TODO Auto-generated method stub
		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
		if (optionalEmployee.isEmpty()) {
			return null;
		}
		
		Employee employee = optionalEmployee.get();
		employee.setFullName(dtoEmployeeIU.getFullName());

		if (dtoEmployeeIU.getDepartmentId() == null) {
			employee.setDepartment(null);
		} else {
			Optional<Department> optionalDepartment = departmentRepository.findById(dtoEmployeeIU.getDepartmentId());
			if (optionalDepartment.isPresent()) {
				Department department = optionalDepartment.get();
				employee.setDepartment(department);
			}
		}

		return getEmployeeById(employeeRepository.save(employee).getId());
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		// TODO Auto-generated method stub
		Optional<Employee> optional = employeeRepository.findById(employeeId);
		if (optional.isPresent()) {
			Employee employee = optional.get();
			employeeRepository.delete(employee);
		}
	}

}
