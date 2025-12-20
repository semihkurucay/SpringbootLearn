package com.springlesson.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoCostumerIU {
	@NotEmpty(message = "İsim alanı boş geçilemez")
	@Size(min = 3, max = 25, message = "Karekter aşımı! 3 ile 25 karakter arasında giriş yapın isim alanına.")
	private String firstName;
	
	@NotEmpty(message = "Soyisim alanı boş geçilemez")
	@Size(min = 3, max = 25, message = "Karekter aşımı! 3 ile 25 karakter arasında giriş yapın soyisim alanına.")
	private String lastName;
	
	@Size(min = 10, max = 15, message = "Karakter aşımı! 10 ile 15 karakter arasında giriş yapın telefon alanına")
	private String phone;
	
	@Email(message = "Geçersiz mail formatı")
	private String mail;
	
	private DtoAddressIU address;
}
