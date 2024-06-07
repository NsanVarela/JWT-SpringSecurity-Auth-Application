package com.jwt.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ResourceController {
	
	@GetMapping("/resource")
	public ResponseEntity<String>getResource() {
		// Récupérer l'objet d'authentification de Spring Security
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        // Vérifier si l'utilisateur est authentifié
        if (authentication != null && authentication.isAuthenticated()) {
        	// L'utilisateur est authentifié, on accorde l'accès à la ressource
        	String resource = "You are authorized to access this protected resource";
        	return ResponseEntity.ok(resource);
        } else {
        	// L'utilisateur n'est pas authentifié, on retourne une réponse d'erreur 401 (Unauthorized)
        	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("If you are not authenticated, we cannot authorize you to access this resource.");
        }
		
	}
}
