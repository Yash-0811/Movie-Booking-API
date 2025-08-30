package com.example.MovieBookingApplication.Service;

import java.util.HashSet;
import java.util.Set;
import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.MovieBookingApplication.DTO.LoginRequestDTO;
import com.example.MovieBookingApplication.DTO.LoginResponseDTO;
import com.example.MovieBookingApplication.DTO.RegisterRequestDTO;
import com.example.MovieBookingApplication.Entity.User;
import com.example.MovieBookingApplication.Respository.UserRepository;
import com.example.MovieBookingApplication.jwt.JwtService;

@Service
public class AuthenticationService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;

	public User registerNormalUser(RegisterRequestDTO registerRequestDTO) {

		if (userRepository.findByUsername(registerRequestDTO.getUsername()).isPresent()) {
			throw new RuntimeException("User already registered");
		}

		Set<String> roles = new HashSet<String>();
		roles.add("ROLE_USER");

		User user = new User();
		user.setUsername(registerRequestDTO.getUsername());
		user.setEmail(registerRequestDTO.getEmail());
		user.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
		user.setRoles(roles);

		return userRepository.save(user);
	}

	public User registerAdminUser(RegisterRequestDTO registerRequestDTO) {

		if (userRepository.findByUsername(registerRequestDTO.getUsername()).isPresent()) {
			throw new RuntimeException("User already registered");
		}

		Set<String> roles = new HashSet<String>();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");

		User user = new User();
		user.setUsername(registerRequestDTO.getUsername());
		user.setEmail(registerRequestDTO.getEmail());
		user.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
		user.setRoles(roles);

		return userRepository.save(user);
	}
	
	public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
		
		User user = userRepository.findByUsername(loginRequestDTO.getUsername())
				 				  .orElseThrow(() -> new RuntimeException("User not found"));
		
		authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							loginRequestDTO.getUsername(),
							loginRequestDTO.getPassword()
							)
				);
		
		String token = jwtService.generateToken(user);
		
		LoginResponseDTO response = new LoginResponseDTO();
		response.setJwtToken(token);
		response.setUsername(user.getUsername());
		response.setRoles(user.getRoles());
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
