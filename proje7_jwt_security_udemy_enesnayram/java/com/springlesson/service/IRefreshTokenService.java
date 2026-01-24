package com.springlesson.service;

import com.springlesson.entity.RefreshToken;
import com.springlesson.entity.User;
import com.springlesson.jwt.AuthResponse;
import com.springlesson.jwt.RefreshTokenRequest;

public interface IRefreshTokenService {
	public RefreshToken createRefreshToken(User user);
	public AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
