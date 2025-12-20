package com.springlesson.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlesson.dto.DtoStudent;
import com.springlesson.dto.DtoStudentIU;
import com.springlesson.entites.Student;
import com.springlesson.repository.StudentRepository;
import com.springlesson.services.IStudentServices;

@Service
public class StudentServicesImpl implements IStudentServices {
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
		// TODO Auto-generated method stub
		DtoStudent dtoStudent = new DtoStudent();
		Student student = new Student();
		
		BeanUtils.copyProperties(dtoStudentIU, student);
		BeanUtils.copyProperties(studentRepository.save(student), dtoStudent);
		
		return dtoStudent;
	}

	@Override
	public List<DtoStudent> getAllStudent() {
		// TODO Auto-generated method stub
		List<DtoStudent> dtoStudentList = new ArrayList<>();
		
		for(Student student : studentRepository.findAllStudents()){
			DtoStudent dtoStudent = new DtoStudent();
			BeanUtils.copyProperties(student, dtoStudent);
			dtoStudentList.add(dtoStudent);
		}
		
		return dtoStudentList;
	}

	@Override
	public DtoStudent getStudentById(Long id) {
		// TODO Auto-generated method stub
		Optional<Student> optional = studentRepository.findStudentById(id);
		
		if(optional.isPresent()) {
			DtoStudent dtoStudent = new DtoStudent();
			BeanUtils.copyProperties(optional.get(), dtoStudent);
			return dtoStudent;
		}
		
		return null;
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		Optional<Student> optional = studentRepository.findById(id);
		
		if(optional.isPresent()) {
			studentRepository.delete(optional.get());
		}
	}

	@Override
	public DtoStudent updateStudent(Long id, DtoStudentIU dtoStudentUI) {
		// TODO Auto-generated method stub
		Optional<Student> optional = studentRepository.findById(id);
		
		if(optional.isPresent()) {
			DtoStudent dtoStudent = new DtoStudent();
			
			optional.get().setFirstName(dtoStudentUI.getFirstName());
			optional.get().setLastName(dtoStudentUI.getLastName());
			optional.get().setBirthOfDate(dtoStudentUI.getBirthOfDate());
			
			BeanUtils.copyProperties(studentRepository.save(optional.get()), dtoStudent);
			
			return dtoStudent;
		}
		
		return null;
	}
}
