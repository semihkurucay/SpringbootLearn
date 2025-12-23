package com.springlesson.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoDepartmentIU {
	@NotEmpty(message = "Departman adı boş geçilemez.")
	@Size(min = 2, max = 25, message = "Departman adı en az 2, en fazla 25 karakter girin.")
	private String departmentName;
}
