package com.springlesson.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoEmployee {
	private Long id;
	private String firstName;
	private String lastName;
	private DtoDepatment department;
}
