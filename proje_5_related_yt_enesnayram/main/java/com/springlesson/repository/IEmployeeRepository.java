package com.springlesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springlesson.entites.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long>{

}
