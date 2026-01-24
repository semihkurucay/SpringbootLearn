package com.springlesson.controller;

import java.util.List;

import com.springlesson.dto.DtoEmployee;
import com.springlesson.dto.DtoEmployeeIU;
import com.springlesson.entity.RootEntity;

public interface IEmployeeController {
	public RootEntity<List<DtoEmployee>> getAllEmployee();
	public RootEntity<DtoEmployee> getEmployeeById(Long employeeId);
	public RootEntity<DtoEmployee> saveEmployee(DtoEmployeeIU dtoEmployeeIU);
	public RootEntity<DtoEmployee> updateEmployee(Long employeeId, DtoEmployeeIU dtoEmployeeIU);
	public void deleteEmployee(Long employeeId);
}
