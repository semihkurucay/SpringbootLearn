package com.springlesson.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoAddressIU {
	@NotEmpty(message = "Şehir alanı boş geçilemez")
	@Size(min = 3, max = 15, message = "Karekter aşımı! 3 ile 15 karakter arasında giriş yapın şehir alanına.")
	private String city;
	
	//@NotEmpty(message = "İlçe alanı boş geçilemez")
	@Size(min = 3, max = 25, message = "Karekter aşımı! 3 ile 25 karakter arasında giriş yapın ilçe alanına.")
	private String district;
	
	//@NotEmpty(message = "Açıklama alanı boş geçilemez")
	@Size(min = 3, max = 250, message = "Karekter aşımı! 3 ile 250 karakter arasında giriş yapın açıklama alanına.")
	private String description;
	
	//private DtoCostumerIU costumer;
}
