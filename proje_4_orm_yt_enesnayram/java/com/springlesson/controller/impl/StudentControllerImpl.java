package com.springlesson.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {
	@Autowired
	private IStudentServices studentService;
	
	@PostMapping(path = "/save")
	@Override
	public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU dtoStudentIU) {
		// TODO Auto-generated method stub
		return studentService.saveStudent(dtoStudentIU);
	}

	@GetMapping(path = "/list")
	@Override
	public List<DtoStudent> getAllStudent() {
		// TODO Auto-generated method stub
		return studentService.getAllStudent();
	}

	@GetMapping(path = "/list/{id}")
	@Override
	public DtoStudent getStudentById(@PathVariable(name = "id") Long id) {
		// TODO Auto-generated method stub
		return studentService.getStudentById(id);
	}

	@DeleteMapping("/delete/{id}")
	@Override
	public void deleteStudent(@PathVariable(name = "id") Long id) {
		// TODO Auto-generated method stub
		studentService.deleteStudent(id);
	}

	@PutMapping("/update/{id}")
	@Override
	public DtoStudent updateStudent(@PathVariable(name = "id") Long id,@RequestBody @Valid DtoStudentIU dtoStudentIU) {
		// TODO Auto-generated method stub
		return studentService.updateStudent(id, dtoStudentIU);
	}
}
