package com.springlesson.dto;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {
	@NotEmpty(message = "İsim boş geçilemez")
	@Min(value = 3, message = "En az 3 karakter olmalı isim alanı")
	@Max(value = 10, message = "En fazla 10 karakter olmalı isim alanı")
	private String firstName;
	
	@Size(min = 3, max = 10, message = "En az 3, en fazla 10 karakter olmalı soyisim alanı")
	private String lastName;
	
	private Date birthOfDate;
	
	@Email(message = "Geçersiz mail adresi")
	private String mail;
	
	@Size(max = 11, min = 11, message = "Geçersiz TC, 11 karakter olmalı")
	@NotEmpty(message = "TC boş geçilemez")
	private String tckn;
}
