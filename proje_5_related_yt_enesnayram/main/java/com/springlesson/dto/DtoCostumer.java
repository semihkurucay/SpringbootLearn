package com.springlesson.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoCostumer {
	private Long id;
	private String firstName;
	private String lastName;
	private DtoAddress address;
}
