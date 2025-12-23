package com.springlesson.dto;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {
	@NotEmpty(message = "Öğrenci adı boş geçilemez.")
	@Size(min = 2, max = 25, message = "Öğrenci adı en az 2, en fazla 25 karakter girin.")
	private String firstName;
	
	@NotEmpty(message = "Öğrenci soyadı boş geçilemez.")
	@Size(min = 2, max = 25, message = "Öğrenci soyadı en az 2, en fazla 25 karakter girin.")
	private String lastName;
	private Date birthOfDate;
	List<Long> courseIds;
}
