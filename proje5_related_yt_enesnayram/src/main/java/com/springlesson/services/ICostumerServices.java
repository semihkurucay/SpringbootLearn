package com.springlesson.services;

import java.util.List;

import com.springlesson.dto.DtoCostumer;
import com.springlesson.dto.DtoCostumerIU;

public interface ICostumerServices {
	public DtoCostumer saveCostumer(DtoCostumerIU dtoCostumerIU);
	public List<DtoCostumer> listAllCostumer();
	public DtoCostumer getCostumerById(Long costumerId);
	public void deleteCostumer(Long costumerId);
	public DtoCostumer updateCostumer(DtoCostumerIU dtoCostumerIU, Long costumerId);
}
