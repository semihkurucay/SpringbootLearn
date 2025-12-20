package com.springlesson.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springlesson.entites.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	@Query(value = "FROM Student" , nativeQuery = false) //Hibernate Sorgusu HQL
	List<Student> findAllStudents();
	
	/*@Query(value = "SELECT * FROM Student" , nativeQuery = true) //SQL Sorgusu
	List<Student> findAllStudents();*/
	
	@Query(value = "FROM Student WHERE id = :studentID" , nativeQuery = false) //Hibernate Sorgusu HQL
	Optional<Student> findStudentById(Long studentID);
	
	/*@Query(value = "SELECT * FROM Student WHERE id = ?" , nativeQuery = true) //SQL Sorgusu
	Optional<Student> findStudentById(Long studentID);*/
}
