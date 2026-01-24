package com.springlesson.controller;

import com.springlesson.dto.DtoUser;
import com.springlesson.jwt.AuthRequest;
import com.springlesson.jwt.AuthResponse;
import com.springlesson.jwt.RefreshTokenRequest;

public interface IRestAuthController {
	public DtoUser register(AuthRequest request);
	public AuthResponse authenticate(AuthRequest request);
	public AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
