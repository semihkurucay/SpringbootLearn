package com.springlesson.dto;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoHomeIU {
	private BigDecimal price;
	@NotEmpty(message = "Konum alanı boş geçilemez")
	@Size(min = 1, max = 200, message = "En az 1, en fazla 200 karakter girin konuma")
	private String location;
	private List<DtoRoomIU> rooms;
}
