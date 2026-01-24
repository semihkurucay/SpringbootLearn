package com.springlesson.service;

import com.springlesson.dto.DtoUser;
import com.springlesson.jwt.AuthRequest;
import com.springlesson.jwt.AuthResponse;

public interface IAuthService {
	public DtoUser register(AuthRequest request);
	public AuthResponse authenticate(AuthRequest request);
}
