package com.springlesson.exception;

import lombok.Getter;

@Getter
public enum MessageType {
	NO_RECORD_EXIST("1001", "Kayıt bulunamadı"),
	GENERAL_EXCEPTİON("9999", "Genel bir hata oluştu");
	
	
	private String code;
	private String message;
	
	MessageType(String code, String message) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.message = message;
	}
}
