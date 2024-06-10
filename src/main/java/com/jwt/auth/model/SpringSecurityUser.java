package com.jwt.auth.model;

import java.util.List;

public class SpringSecurityUser {
    private String username;
    private String email;
    private List<String> roles;

    public SpringSecurityUser(String username, String email, List<String> roles) {
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
