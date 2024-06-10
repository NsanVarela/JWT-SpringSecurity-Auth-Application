package com.jwt.auth.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.user.model.SpringSecurityUser;
//import com.jwt.mock.controller.UserDetailsManagerController;
//import com.jwt.mock.model.UserDetailsManagerModel;
import com.jwt.user.model.User;

@RestController
@RequestMapping("/api")
public class ResourceController {
	
	private final UserDetailsService userDetailsService;
	private final InMemoryUserDetailsManager userDetailsManager;

    @Autowired
    public ResourceController(UserDetailsService userDetailsService, InMemoryUserDetailsManager userDetailsManager) {
        this.userDetailsService = userDetailsService;
        this.userDetailsManager = userDetailsManager;
    }
	
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
	
	/**
	 * Récupère l'objet d'authentification de Spring Security
	 * @return User
	 */
	@GetMapping("/in-memory-user")
	public SpringSecurityUser getUserSpringInfo() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        
        // l'email n'est pas disponible par défaut dans UserDetails
        String email = "user@example.com";

        List<String> roles = authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.toList());

        return new SpringSecurityUser(username, email, roles);
	}
	
	/**
	 * Récupère utilisateur de Spring Security par son nom
	 * @param username
	 * @return User
	 */
	@GetMapping("/in-memory-user/{username}")
	public SpringSecurityUser getUserByUserName(@PathVariable String username) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        List<String> roles = userDetails.getAuthorities().stream()
                .map(authority -> authority.getAuthority())
                .collect(Collectors.toList());
        // l'email n'est pas disponible par défaut dans UserDetails
        String email = "user@example.com";
        return new SpringSecurityUser(userDetails.getUsername(), email, roles);
    }
	
	/**
	 * Récupère la liste des utilisateurs de Spring Security
	 * @return usernames
	 */
	@GetMapping("/in-memory-users")
    public List<String> getUsers() {
		List<String> usernames = new ArrayList<>();

		try {
			// On utilise la réflexion pour accéder à la map des utilisateurs
			Field field = InMemoryUserDetailsManager.class.getDeclaredField("users");
			field.setAccessible(true);
			Map<String, UserDetails> usersMap = (Map<String, UserDetails>) field.get(userDetailsManager);
			
			// On parcours la map des utilisateurs et récupérer les noms d'utilisateur
			for (Map.Entry<String, UserDetails> entry : usersMap.entrySet()) {
				usernames.add(entry.getKey());
			}
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return usernames;
    }
}
