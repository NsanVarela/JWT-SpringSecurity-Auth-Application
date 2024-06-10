package com.jwt.user.model;

import java.util.List;

//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
public class User {
	
	private long id;
	private String userName;
	private String password;
	private String email;
	private String firstName;
	private Byte[] image;
	private String telephone;
	private int approved;
	private List<String> roles;
	
	public User() { }
	
	public User(String userName, String email, List<String> roles) {
		this.userName = userName;
		this.email = email;
		this.roles = roles;
	}
	
}
