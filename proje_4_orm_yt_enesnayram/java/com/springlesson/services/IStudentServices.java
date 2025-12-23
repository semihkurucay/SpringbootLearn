package com.springlesson.services;

import java.util.List;

import com.springlesson.dto.DtoStudent;
import com.springlesson.dto.DtoStudentIU;

public interface IStudentServices {
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
	public List<DtoStudent> getAllStudent();
	public DtoStudent getStudentById(Long id);
	public void deleteStudent(Long id);
	public DtoStudent updateStudent(Long id, DtoStudentIU dtoStudentUI);
}
