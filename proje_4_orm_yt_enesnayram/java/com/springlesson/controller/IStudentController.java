package com.springlesson.controller;

import java.util.List;

import com.springlesson.dto.DtoStudent;
import com.springlesson.dto.DtoStudentIU;

public interface IStudentController {
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
	public List<DtoStudent> getAllStudent();
	public DtoStudent getStudentById(Long id);
	public void deleteStudent(Long id);
	public DtoStudent updateStudent(Long id, DtoStudentIU dtoStudentIU);
}
