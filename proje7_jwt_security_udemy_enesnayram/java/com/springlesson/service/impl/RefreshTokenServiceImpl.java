package com.springlesson.service.impl;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlesson.entity.RefreshToken;
import com.springlesson.entity.User;
import com.springlesson.jwt.AuthResponse;
import com.springlesson.jwt.JwtService;
import com.springlesson.jwt.RefreshTokenRequest;
import com.springlesson.repository.IRefreshTokenRepository;
import com.springlesson.service.IRefreshTokenService;

@Service
public class RefreshTokenServiceImpl implements IRefreshTokenService {
	@Autowired
	private IRefreshTokenRepository refreshTokenRepository;

	@Autowired
	private JwtService jwtService;
	
	@Override
	public RefreshToken createRefreshToken(User user) {
		// TODO Auto-generated method stub
		RefreshToken refreshToken = new RefreshToken();
		refreshToken.setRefreshToken(UUID.randomUUID().toString());
		refreshToken.setExpireDate(new Date(System.currentTimeMillis() + 1000*60*60*4));
		refreshToken.setUser(user);
		
		return refreshTokenRepository.save(refreshToken);
	}

	private Boolean isRefreshTokenExpried(Date expriedToken) {
		return new Date().before(expriedToken);
	}
	
	@Override
	public AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
		// TODO Auto-generated method stub
		Optional<RefreshToken> optional = refreshTokenRepository.findByRefreshToken(refreshTokenRequest.getRefreshToken());
		if(optional.isEmpty()) {
			System.err.println("Geçersiz refresh token");
			return null;
		}
		
		RefreshToken refreshToken = optional.get();
		
		if(!isRefreshTokenExpried(refreshToken.getExpireDate())){
			System.err.println("Token süresi doldu");
			return null;
		}
		
		String accessToken = jwtService.generateToken(refreshToken.getUser());
		RefreshToken newRefreshToken = createRefreshToken(refreshToken.getUser());
		
		return new AuthResponse(accessToken, newRefreshToken.getRefreshToken());
	}
}
