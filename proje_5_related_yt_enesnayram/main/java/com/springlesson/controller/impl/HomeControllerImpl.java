package com.springlesson.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springlesson.controller.IHomeController;
import com.springlesson.dto.DtoHome;
import com.springlesson.dto.DtoHomeIU;
import com.springlesson.services.IHomeServices;

@RestController
@RequestMapping(path = "/rest/api/home")
public class HomeControllerImpl implements IHomeController{
	@Autowired
	private IHomeServices homeServices;
	
	@GetMapping(path = "/list/{id}")
	@Override
	public DtoHome getHomeById(@PathVariable(name = "id") Long homeId) {
		// TODO Auto-generated method stub
		return homeServices.getHomeById(homeId);
	}

	@GetMapping(path = "/list")
	@Override
	public List<DtoHome> getAllHome() {
		// TODO Auto-generated method stub
		return homeServices.getAllHome();
	}

	@PostMapping(path = "/save")
	@Override
	public DtoHome saveHome(@RequestBody @Validated DtoHomeIU dtoHomeIU) {
		// TODO Auto-generated method stub
		return homeServices.saveHome(dtoHomeIU);
	}

	@PutMapping(path = "/update/{id}")
	@Override
	public DtoHome updateHome(@PathVariable(name = "id") Long homeId, @RequestBody @Validated DtoHomeIU dtoHomeIU) {
		// TODO Auto-generated method stub
		return homeServices.updateHome(homeId, dtoHomeIU);
	}

	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteHome(@PathVariable(name = "id") Long homeId) {
		// TODO Auto-generated method stub
		homeServices.deleteHome(homeId);
	}

}
