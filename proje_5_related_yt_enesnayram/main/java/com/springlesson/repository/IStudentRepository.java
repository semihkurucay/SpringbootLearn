package com.springlesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springlesson.entites.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long>{

}
