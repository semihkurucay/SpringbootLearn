package com.springlesson.service;

import com.springlesson.dto.DtoEmployee;

public interface IEmployeeService {
	DtoEmployee findEmployeeById(Long id);
}
