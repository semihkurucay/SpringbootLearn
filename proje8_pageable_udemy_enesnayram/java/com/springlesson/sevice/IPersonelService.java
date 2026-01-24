package com.springlesson.sevice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springlesson.dto.DtoPersonel;
import com.springlesson.entity.Personel;

public interface IPersonelService {
	Page<Personel> findAllPageable(Pageable pageable);
	List<DtoPersonel> toDtoLit(List<Personel> personelList);
}
