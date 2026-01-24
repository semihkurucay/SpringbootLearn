package com.springlesson.sevice.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springlesson.dto.DtoDepartment;
import com.springlesson.dto.DtoPersonel;
import com.springlesson.entity.Personel;
import com.springlesson.respository.IPersonelRepository;
import com.springlesson.sevice.IPersonelService;

@Service
public class PersonelServiceImpl implements IPersonelService {
	@Autowired
	private IPersonelRepository personelRepository;

	@Override
	public Page<Personel> findAllPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		//return personelRepository.findAll(pageable);
		return personelRepository.findAllPageable(pageable);
	}

	@Override
	public List<DtoPersonel> toDtoLit(List<Personel> personelList) {
		// TODO Auto-generated method stub
		List<DtoPersonel> dtoPersonelList = new ArrayList<>();
		
		for(Personel personel : personelList) {
			DtoPersonel dtoPersonel = new DtoPersonel();
			BeanUtils.copyProperties(personel, dtoPersonel);
			
			DtoDepartment dtoDepartment = new DtoDepartment();
			BeanUtils.copyProperties(personel.getDepartment(), dtoDepartment);
			dtoPersonel.setDtoDepartment(dtoDepartment);
			
			dtoPersonelList.add(dtoPersonel);
		}
		
		return dtoPersonelList;
	}
}
