package com.springlesson.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springlesson.controller.IStudentController;
import com.springlesson.dto.DtoStudent;
import com.springlesson.dto.DtoStudentIU;
import com.springlesson.services.IStudentServices;

@RestController
@RequestMapping(path = "/rest/api/student")
public class StudentControllerImpl implements IStudentController {
	@Autowired
	private IStudentServices studentServices;
	
	@GetMapping(path = "/list")
	@Override
	public List<DtoStudent> getStudentAll() {
		// TODO Auto-generated method stub
		return studentServices.getStudentAll();
	}

	@GetMapping(path = "/list/{id}")
	@Override
	public DtoStudent getStudentById(@PathVariable(name = "id") Long studentId) {
		// TODO Auto-generated method stub
		return studentServices.getStudentById(studentId);
	}

	@PostMapping(path = "/save")
	@Override
	public DtoStudent saveStudent(@RequestBody @Validated DtoStudentIU dtoStudentIU) {
		// TODO Auto-generated method stub
		return studentServices.saveStudent(dtoStudentIU);
	}

	@PutMapping(path = "/update/{id}")
	@Override
	public DtoStudent updateStudent(@PathVariable(name = "id") Long studentId, @RequestBody @Validated DtoStudentIU dtoStudentIU) {
		// TODO Auto-generated method stub
		return studentServices.updateStudent(studentId, dtoStudentIU);
	}

	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteStudent(@PathVariable(name = "id") Long studentId) {
		// TODO Auto-generated method stub
		studentServices.deleteStudent(studentId);
	}

}
