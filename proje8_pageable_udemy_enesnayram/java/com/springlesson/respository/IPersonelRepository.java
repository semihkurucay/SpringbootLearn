package com.springlesson.respository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springlesson.entity.Personel;

@Repository
public interface IPersonelRepository extends JpaRepository<Personel, Long> {
	@Query(value = "FROM Personel")
	Page<Personel> findAllPageable(Pageable pageable);
}
