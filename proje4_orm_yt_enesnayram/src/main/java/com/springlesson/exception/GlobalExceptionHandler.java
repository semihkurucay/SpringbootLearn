package com.springlesson.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	private List<String> addMapValue(List<String> list, String newValue){
		list.add(newValue);
		return list;
	}
	
	private <T> ApiError<T> createApiError(T errors) {
		return new ApiError<T>(UUID.randomUUID().toString(), new Date(), errors);
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		Map<String, List<String>> errorMap = new HashMap<>();
		
		for(ObjectError objectError : e.getBindingResult().getAllErrors()) {
			String fieldName = ((FieldError)objectError).getField();
			
			if(errorMap.containsKey(fieldName)) {
				errorMap.put(fieldName, addMapValue(errorMap.get(fieldName), objectError.getDefaultMessage()));
			}else {
				errorMap.put(fieldName,addMapValue(new ArrayList<>(), objectError.getDefaultMessage()));
			}
		}
		
		return ResponseEntity.badRequest().body(createApiError(errorMap));
	}
}
