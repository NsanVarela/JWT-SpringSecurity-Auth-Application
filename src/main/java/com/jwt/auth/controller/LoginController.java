package com.jwt.auth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.auth.services.JWTService;

@RestController
public class LoginController {

	public JWTService jwtService;

	public LoginController(JWTService jwtService) {
		this.jwtService = jwtService;
	}
	
	@PostMapping("/login")
	public String getToken(Authentication authentication) {
		String token = jwtService.generateToken(authentication);
		return token;
	}
	
}
