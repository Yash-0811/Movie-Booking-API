package com.example.MovieBookingApplication.DTO;

import java.util.Set;

public class LoginResponseDTO {
	private String jwtToken;
	private String username;
	private Set<String> roles;

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public LoginResponseDTO(String jwtToken, String username, Set<String> roles) {
		super();
		this.jwtToken = jwtToken;
		this.username = username;
		this.roles = roles;
	}

	public LoginResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
