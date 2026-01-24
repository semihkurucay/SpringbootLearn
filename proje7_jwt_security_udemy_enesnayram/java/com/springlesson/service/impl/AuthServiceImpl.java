package com.springlesson.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springlesson.dto.DtoUser;
import com.springlesson.entity.RefreshToken;
import com.springlesson.entity.User;
import com.springlesson.jwt.AuthRequest;
import com.springlesson.jwt.AuthResponse;
import com.springlesson.jwt.JwtService;
import com.springlesson.repository.IUserRepository;
import com.springlesson.service.IAuthService;
import com.springlesson.service.IRefreshTokenService;

@Service
public class AuthServiceImpl implements IAuthService {
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private IRefreshTokenService refreshTokenService;
	
	@Override
	public AuthResponse authenticate(AuthRequest request) {
		// TODO Auto-generated method stub
		try {
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
			authenticationProvider.authenticate(auth);
			
			Optional<User> optinalUser = userRepository.findByUsername(request.getUsername());
			if(optinalUser.isPresent()) {
				User user = optinalUser.get();
				
				String accessToken = jwtService.generateToken(user);
				RefreshToken refreshToken = refreshTokenService.createRefreshToken(user);
				
				return new AuthResponse(accessToken, refreshToken.getRefreshToken());
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Hatalı değer, " + e.getMessage());
		}
		return null;
	}
	
	@Override
	public DtoUser register(AuthRequest request) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		
		User savedUser = userRepository.save(user);
		DtoUser dtoUser = new DtoUser();
		BeanUtils.copyProperties(savedUser, dtoUser);
		
		return dtoUser;
	}
}
