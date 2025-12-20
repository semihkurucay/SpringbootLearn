package com.springlesson.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springlesson.controller.ICostumerController;
import com.springlesson.dto.DtoCostumer;
import com.springlesson.dto.DtoCostumerIU;
import com.springlesson.services.ICostumerServices;

@RestController
@RequestMapping(path = "/rest/api/costumer")
@CrossOrigin(origins = "*")
public class CostumerControllerImpl implements ICostumerController {
	@Autowired
	private ICostumerServices costumerServices;
	
	@PostMapping(path = "/save")
	@Override
	public DtoCostumer saveCostumer(@RequestBody @Validated DtoCostumerIU dtoCostumerIU) {
		// TODO Auto-generated method stub
		return costumerServices.saveCostumer(dtoCostumerIU);
	}

	@GetMapping(path = "/list")
	@Override
	public List<DtoCostumer> listAllCostumer() {
		// TODO Auto-generated method stub
		return costumerServices.listAllCostumer();
	}

	@GetMapping(path = "/list/{id}")
	@Override
	public DtoCostumer getCostumerById(@PathVariable(name = "id") Long costumerId) {
		// TODO Auto-generated method stub
		return costumerServices.getCostumerById(costumerId);
	}

	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteCostumer(@PathVariable(name = "id") Long costumerId) {
		// TODO Auto-generated method stub
		costumerServices.deleteCostumer(costumerId);
	}

	@PutMapping(path = "/update/{id}")
	@Override
	public DtoCostumer updateCostumer(@RequestBody @Validated DtoCostumerIU dtoCostumerIU, @PathVariable(name = "id") Long costumerId) {
		// TODO Auto-generated method stub
		return costumerServices.updateCostumer(dtoCostumerIU, costumerId);
	}
}
