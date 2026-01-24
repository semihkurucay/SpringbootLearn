package com.springlesson.controller;

import com.springlesson.dto.DtoPersonel;
import com.springlesson.utils.RestPageableEntity;
import com.springlesson.utils.RestPageableRequest;
import com.springlesson.utils.RestRootEntity;

public interface IRestPersonelController {
	public RestRootEntity<RestPageableEntity<DtoPersonel>> findAllPageable(RestPageableRequest pageableRequest);
}
