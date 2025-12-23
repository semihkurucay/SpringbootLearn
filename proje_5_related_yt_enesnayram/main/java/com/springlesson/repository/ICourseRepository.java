package com.springlesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springlesson.entites.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {

}
