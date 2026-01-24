package com.springlesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springlesson.entity.Department;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Long>{

}
