package com.springlesson.controller;

import java.util.List;

import com.springlesson.dto.DtoCostumer;
import com.springlesson.dto.DtoCostumerIU;

public interface ICostumerController {
	public DtoCostumer saveCostumer(DtoCostumerIU dtoCostumerIU);
	public List<DtoCostumer> listAllCostumer();
	public DtoCostumer getCostumerById(Long costumerId);
	public void deleteCostumer(Long costumerId);
	public DtoCostumer updateCostumer(DtoCostumerIU dtoCostumerIU, Long costumerId);
}
