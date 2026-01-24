package com.springlesson.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springlesson.controller.IRestAuthController;
import com.springlesson.dto.DtoUser;
import com.springlesson.jwt.AuthRequest;
import com.springlesson.jwt.AuthResponse;
import com.springlesson.jwt.RefreshTokenRequest;
import com.springlesson.service.IAuthService;
import com.springlesson.service.IRefreshTokenService;

@RestController
public class RestAuthControllerImpl implements IRestAuthController {
	@Autowired
	private IAuthService authService;
	
	@Autowired
	private IRefreshTokenService refreshTokenService;
	
	@PostMapping("/register")
	@Override
	public DtoUser register(@RequestBody @Validated AuthRequest request) {
		// TODO Auto-generated method stub
		return authService.register(request);
	}

	@PostMapping("/authenticate")
	@Override
	public AuthResponse authenticate(@Validated @RequestBody AuthRequest request) {
		// TODO Auto-generated method stub
		return authService.authenticate(request);
	}

	@PostMapping("/refreshToken")
	@Override
	public AuthResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
		// TODO Auto-generated method stub
		return refreshTokenService.refreshToken(refreshTokenRequest);
	}

}
