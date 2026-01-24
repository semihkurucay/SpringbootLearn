package com.springlesson.utils;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PagerUtil {
	public boolean isNullOrEmpty(String value) {
		return value == null || value.trim().length() == 0;
	}
	
	public Pageable toPageable(RestPageableRequest pageableRequest) {
		if(!isNullOrEmpty(pageableRequest.getColumnName())) {
			Sort sort = pageableRequest.isAsc() ? Sort.by(Direction.ASC, pageableRequest.getColumnName()) : Sort.by(Direction.DESC, pageableRequest.getColumnName());
			
			return PageRequest.of(pageableRequest.getPageNumber(), pageableRequest.getPageSize(), sort);
		}
		
		return PageRequest.of(pageableRequest.getPageNumber(), pageableRequest.getPageSize());
	}
	
	public <T> RestPageableEntity<T> pageableResponse(Page<?> page, List<T> content) {
		RestPageableEntity<T> pageableEntity = new RestPageableEntity<>();
		pageableEntity.setContent(content);
		pageableEntity.setPageNumber(page.getPageable().getPageNumber());
		pageableEntity.setPageSize(page.getPageable().getPageSize());
		pageableEntity.setTotalElements(page.getTotalElements());
		
		return pageableEntity;
	}
}
