package com.springlesson.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlesson.dto.DtoAddress;
import com.springlesson.dto.DtoCostumer;
import com.springlesson.dto.DtoCostumerIU;
import com.springlesson.entites.Address;
import com.springlesson.entites.Costumer;
import com.springlesson.repository.ICostumerRepository;
import com.springlesson.services.ICostumerServices;

@Service
public class CostumerServicesImpl implements ICostumerServices{
	@Autowired
	private ICostumerRepository costumerRespository;
	
	@Override
	public DtoCostumer saveCostumer(DtoCostumerIU dtoCostumerIU) {
		// TODO Auto-generated method stub
		Address address = new Address();
		BeanUtils.copyProperties(dtoCostumerIU.getAddress(), address);
		
		Costumer costumer = new Costumer();
		BeanUtils.copyProperties(dtoCostumerIU, costumer);
		
		costumer.setAddress(address);
		Costumer savedCostumer = costumerRespository.save(costumer);
		
		DtoCostumer dtoCostumer = new DtoCostumer();
		BeanUtils.copyProperties(savedCostumer, dtoCostumer);
		
		DtoAddress dtoAddress = new DtoAddress();
		BeanUtils.copyProperties(savedCostumer.getAddress(), dtoAddress);
		
		dtoCostumer.setAddress(dtoAddress);
		return dtoCostumer;
	}

	@Override
	public List<DtoCostumer> listAllCostumer() {
		// TODO Auto-generated method stub
		List<DtoCostumer> dtoCostumers = new ArrayList<>();
		
		for(Costumer costumer : costumerRespository.findAll()) {
			DtoCostumer tempDtoCostumer = new DtoCostumer();
			DtoAddress tempDtoAddress = new DtoAddress();
			
			BeanUtils.copyProperties(costumer, tempDtoCostumer);
			BeanUtils.copyProperties(costumer.getAddress(), tempDtoAddress);
			
			tempDtoCostumer.setAddress(tempDtoAddress);
			
			dtoCostumers.add(tempDtoCostumer);
		}
		
		return dtoCostumers;
	}

	@Override
	public DtoCostumer getCostumerById(Long costumerId) {
		// TODO Auto-generated method stub
		Optional<Costumer> optional = costumerRespository.findById(costumerId);
		
		if(optional.isPresent()) {
			DtoCostumer dtoCostumer = new DtoCostumer();
			BeanUtils.copyProperties(optional.get(), dtoCostumer);
			return dtoCostumer;
		}
		
		return null;
	}

	@Override
	public void deleteCostumer(Long costumerId) {
		// TODO Auto-generated method stub
		Optional<Costumer> optinal = costumerRespository.findById(costumerId);
		if(optinal.isPresent()) {
			costumerRespository.delete(optinal.get());
		}
	}

	@Override
	public DtoCostumer updateCostumer(DtoCostumerIU dtoCostumerIU, Long costumerId) {
		// TODO Auto-generated method stub
		Optional<Costumer> optinal = costumerRespository.findById(costumerId);
		if(optinal.isPresent()) {
			DtoCostumer dtoCostumer = new DtoCostumer();
			
			optinal.get().setFirstName(dtoCostumerIU.getFirstName());
			optinal.get().setLastName(dtoCostumerIU.getLastName());
			optinal.get().setMail(dtoCostumerIU.getMail());
			optinal.get().setPhone(dtoCostumerIU.getPhone());
			
			optinal.get().getAddress().setCity(dtoCostumerIU.getAddress().getCity());
			optinal.get().getAddress().setDistrict(dtoCostumerIU.getAddress().getDistrict());
			optinal.get().getAddress().setDescription(dtoCostumerIU.getAddress().getDescription());
			
			Costumer savedCostumer = costumerRespository.save(optinal.get());
			
			DtoAddress dtoAddress = new DtoAddress();
			
			BeanUtils.copyProperties(savedCostumer, dtoCostumer);
			BeanUtils.copyProperties(savedCostumer.getAddress(), dtoAddress);
			
			dtoCostumer.setAddress(dtoAddress);
			return dtoCostumer;
		}
		return null;
	}

}
