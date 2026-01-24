package com.springlesson.utils;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class RestRootEntity<T> {
	private int status;
	private T payload;
	private String errorMessage;
	
	public static <T> RestRootEntity<T> ok(T payload) {
		RestRootEntity<T> rootEntity = new RestRootEntity<>();
		rootEntity.setStatus(HttpStatus.OK.value());
		rootEntity.setErrorMessage("");
		rootEntity.setPayload(payload);
		
		return rootEntity;
	}
}
