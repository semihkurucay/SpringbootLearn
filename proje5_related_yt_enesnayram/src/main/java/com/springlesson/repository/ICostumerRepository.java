package com.springlesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springlesson.entites.Costumer;

@Repository
public interface ICostumerRepository extends JpaRepository<Costumer, Long> {

}
