package com.springlesson.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoEmployeeIU {
	@NotEmpty(message = "Çalışan adı boş geçilemez.")
	@Size(min = 2, max = 25, message = "Çalışan adı en az 2, en fazla 25 karakter girin.")
	private String firstName;
	
	@NotEmpty(message = "Çalışan soyadı boş geçilemez.")
	@Size(min = 2, max = 25, message = "Çalışanan soyadı en az 2, en fazla 25 karakter girin.")
	private String lastName;
	
	private Long departmentId;
}
