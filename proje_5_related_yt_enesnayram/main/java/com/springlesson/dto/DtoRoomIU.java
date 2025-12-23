package com.springlesson.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoRoomIU {
	@NotEmpty(message = "Oda adı boş geçilemez")
	@Size(min = 1, max = 100, message = "Oda adı en az 1 ve en fazla 100 karakter girin")
	private String name;
}
