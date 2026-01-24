package com.springlesson.services;

import java.util.List;

import com.springlesson.dto.DtoEmployee;
import com.springlesson.dto.DtoEmployeeIU;

public interface IEmployeeServices {
	public List<DtoEmployee> getAllEmployee();
	public DtoEmployee getEmployeeById(Long employeeId);
	public DtoEmployee saveEmployee(DtoEmployeeIU dtoEmployeeIU);
	public DtoEmployee updateEmployee(Long employeeId, DtoEmployeeIU dtoEmployeeIU);
	public void deleteEmployee(Long employeeId);
}
