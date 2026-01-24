package com.springlesson.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springlesson.controller.IRestPersonelController;
import com.springlesson.dto.DtoPersonel;
import com.springlesson.entity.Personel;
import com.springlesson.sevice.IPersonelService;
import com.springlesson.utils.RestPageableEntity;
import com.springlesson.utils.RestPageableRequest;
import com.springlesson.utils.RestRootEntity;

@RestController
@RequestMapping("/rest/api/personel")
public class RestPersonelControllerImpl extends RestBaseController implements IRestPersonelController {
	@Autowired
	private IPersonelService personelService;

	@GetMapping("/list/pageable")
	@Override
	public RestRootEntity<RestPageableEntity<DtoPersonel>> findAllPageable(RestPageableRequest pageableRequest) {
		// TODO Auto-generated method stub
		Page<Personel> page = personelService.findAllPageable(toPageable(pageableRequest));
		RestPageableEntity<DtoPersonel> pageableEntity = toPageableResponse(page, personelService.toDtoLit(page.getContent()));
		
		return ok(pageableEntity);
	}

}
