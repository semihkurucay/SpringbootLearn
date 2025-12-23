package com.springlesson.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.springlesson.dto.DtoCourse;
import com.springlesson.dto.DtoStudent;
import com.springlesson.dto.DtoStudentIU;
import com.springlesson.entites.Course;
import com.springlesson.entites.Student;
import com.springlesson.repository.ICourseRepository;
import com.springlesson.repository.IStudentRepository;
import com.springlesson.services.IStudentServices;

@Service
public class StudentServicesImpl implements IStudentServices{
	@Autowired
	private IStudentRepository studentRepository;
	
	@Autowired
	private ICourseRepository courseRepository;
	
	@Override
	public List<DtoStudent> getStudentAll() {
		// TODO Auto-generated method stub
		List<DtoStudent> dtoStudentList = new ArrayList<>();
		
		for(Student student : studentRepository.findAll()) {
			DtoStudent dtoStudent = new DtoStudent();
			BeanUtils.copyProperties(student, dtoStudent);
			
			List<Course> courseList = student.getCourses();
			if(courseList != null && !courseList.isEmpty()) {
				for(Course course : courseList) {
					DtoCourse dtoCourse = new DtoCourse();
					BeanUtils.copyProperties(course, dtoCourse);
					dtoStudent.getDtoCourses().add(dtoCourse);
				}
			}
			
			dtoStudentList.add(dtoStudent);
		}
		
		return dtoStudentList;
	}

	@Override
	public DtoStudent getStudentById(Long studentId) {
		// TODO Auto-generated method stub
		Optional<Student> optional = studentRepository.findById(studentId);
		if(optional.isPresent()) {
			Student student = optional.get();
			DtoStudent dtoStudent = new DtoStudent();
			BeanUtils.copyProperties(student, dtoStudent);
			
			List<Course> courseList = student.getCourses();
			if(courseList != null && !courseList.isEmpty()) {
				for(Course course : courseList) {
					DtoCourse dtoCourse = new DtoCourse();
					BeanUtils.copyProperties(course, dtoCourse);
					dtoStudent.getDtoCourses().add(dtoCourse);
				}
			}
			
			return dtoStudent;
		}
		return null;
	}

	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
		// TODO Auto-generated method stub
		Student student = new Student();
		BeanUtils.copyProperties(dtoStudentIU, student);
		
		List<Long> courseIdList = dtoStudentIU.getCourseIds();
		List<Course> foundCourses = courseRepository.findAllById(courseIdList);
		if(foundCourses.size() != courseIdList.size()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bazı ders ID'leri bulunamadı!");
		}
		student.setCourses(foundCourses);
		return getStudentById(studentRepository.save(student).getId());
	}

	@Override
	public DtoStudent updateStudent(Long studentId, DtoStudentIU dtoStudentIU) {
		// TODO Auto-generated method stub
		Optional<Student> optional = studentRepository.findById(studentId);
		if(optional.isPresent()) {
			Student student = optional.get();
			student.setFirstName(dtoStudentIU.getFirstName());
			student.setLastName(dtoStudentIU.getLastName());
			student.setBirthOfDate(dtoStudentIU.getBirthOfDate());
			student.getCourses().clear();
			
			List<Long> courseIdList = dtoStudentIU.getCourseIds();
			List<Course> foundCourses = courseRepository.findAllById(courseIdList);
			if(foundCourses.size() != courseIdList.size()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bazı ders ID'leri bulunamadı!");
			}
			student.setCourses(foundCourses);
			return getStudentById(studentRepository.save(student).getId());
		}
		return null;
	}

	@Override
	public void deleteStudent(Long studentId) {
		// TODO Auto-generated method stub
		Optional<Student> optional = studentRepository.findById(studentId);
		if(optional.isPresent()) {
			studentRepository.delete(optional.get());
		}
	}

}
