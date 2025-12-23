package com.springlesson.services;

import java.util.List;

import com.springlesson.dto.DtoHome;
import com.springlesson.dto.DtoHomeIU;

public interface IHomeServices {
	public DtoHome getHomeById(Long homeId);
	public List<DtoHome> getAllHome();
	public DtoHome saveHome(DtoHomeIU dtoHomeIU);
	public DtoHome updateHome(Long homeId, DtoHomeIU dtoHomeIU);
	public void deleteHome(Long homeId);
}
