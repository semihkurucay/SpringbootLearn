package com.springlesson.jwt;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
	
	@NotEmpty(message = "Username boş geçilemez")
	private String username;
	
	@NotEmpty(message = "Password boş geçilemez")
	private String password;
}
