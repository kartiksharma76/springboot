package com.telusko.SpringSecEx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication; // Correct import
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.telusko.SpringSecEx.model.Users;
import com.telusko.SpringSecEx.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;

	@Autowired
	AuthenticationManager authManager;

	@Autowired
	private JWTService jwtService;
	// Password encoder with strength 12
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	// Register new user
	public Users register(Users user) {

		// Encrypt password before saving
		user.setPassword(encoder.encode(user.getPassword()));

		// Save user to database
		return repo.save(user);
	}

	// Verify login credentials
	public String verify(Users user) {

		Authentication authentication = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getUsername()) ;
		}

		return "Fail";
	}
}