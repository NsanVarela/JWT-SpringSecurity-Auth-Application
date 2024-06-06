package com.jwt.auth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.auth.services.JWTService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Autoriser les requêtes depuis http://localhost:4200
@RequestMapping("/api")
public class LoginController {

	public JWTService jwtService;

	public LoginController(JWTService jwtService) {
		this.jwtService = jwtService;
	}
	
	@PostMapping("/login")
	public String getToken(HttpServletRequest request, Authentication authentication) {
		String token = jwtService.generateToken(authentication);
		
		// Créer une session côté serveur
		HttpSession session = request.getSession(true);
		session.setAttribute("jwtToken", token);
		return token;
	}
	
}
