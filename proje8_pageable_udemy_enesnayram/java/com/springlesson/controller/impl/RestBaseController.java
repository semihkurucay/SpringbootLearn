package com.springlesson.controller.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springlesson.utils.PagerUtil;
import com.springlesson.utils.RestPageableEntity;
import com.springlesson.utils.RestPageableRequest;
import com.springlesson.utils.RestRootEntity;

public class RestBaseController {
	public Pageable toPageable(RestPageableRequest pageableRequest) {
		return PagerUtil.toPageable(pageableRequest);
	}
	
	public <T> RestPageableEntity<T> toPageableResponse(Page<?> page, List<T> content) {
		return PagerUtil.pageableResponse(page, content);
	}
	
	public <T> RestRootEntity<T> ok(T payload){
		return RestRootEntity.ok(payload);
	}
}
