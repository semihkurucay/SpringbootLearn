package com.springlesson.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springlesson.jwt.AuthEntryPoint;
import com.springlesson.jwt.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	public static final String AUTHENTICATE = "/authenticate";
	public static final String REGISTER = "/register";
	public static final String REFRESH_TOKEN = "/refreshToken";
	public static final String[] SWAGGER_UI = { "/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html" };

	@Autowired
	private AuthenticationProvider authenticationProvider;

	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	@Autowired
	private AuthEntryPoint authEntryPoint;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) {
		http.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(request -> request.requestMatchers(AUTHENTICATE, REGISTER, REFRESH_TOKEN)
						.permitAll().requestMatchers(SWAGGER_UI).permitAll().anyRequest().authenticated())
				.exceptionHandling(exception -> exception.authenticationEntryPoint(authEntryPoint))
				.sessionManagement(seesion -> seesion.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authenticationProvider)
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}
