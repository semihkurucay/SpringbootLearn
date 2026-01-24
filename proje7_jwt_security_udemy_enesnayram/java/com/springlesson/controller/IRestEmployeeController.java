package com.springlesson.controller;

import com.springlesson.dto.DtoEmployee;

public interface IRestEmployeeController {
	public DtoEmployee findEmployeeById(Long id);
}
