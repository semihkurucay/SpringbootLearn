package com.springlesson.services;

import java.util.List;

import com.springlesson.dto.DtoStudent;
import com.springlesson.dto.DtoStudentIU;

public interface IStudentServices {
	public List<DtoStudent> getStudentAll();
	public DtoStudent getStudentById(Long studentId);
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
	public DtoStudent updateStudent(Long studentId, DtoStudentIU dtoStudentIU);
	public void deleteStudent(Long studentId);
}
