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
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {
	private List<String> addListValue(List<String> list, String value){
		list.add(value);
		return list;
	}
	
	private <T> ApiError<T> createApiError(T error){
		return new ApiError<T>(UUID.randomUUID().toString(), new Date(), error);
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
		Map<String, List<String>> mapError = new HashMap<>();
		
		for(ObjectError error : e.getBindingResult().getAllErrors()) {
			String fieldName = ((FieldError)error).getField();
			
			if(mapError.containsValue(fieldName)) {
				mapError.put(fieldName, addListValue(mapError.get(fieldName), error.getDefaultMessage()));
			}else {
				mapError.put(fieldName, addListValue(new ArrayList<>(), error.getDefaultMessage()));
			}
		}
		
		return ResponseEntity.badRequest().body(createApiError(mapError));
	}
	
	@ExceptionHandler(value = ResponseStatusException.class)
	public ResponseEntity<ApiError> responException(ResponseStatusException e){
		return ResponseEntity.badRequest().body(createApiError(e.getMessage()));
	}
}
