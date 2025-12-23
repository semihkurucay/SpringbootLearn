package com.springlesson.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springlesson.entites.Home;

@Repository
public interface IHomeRepository extends JpaRepository<Home, Long>{
	
}
