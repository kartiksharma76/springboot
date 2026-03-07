package com.telusko.SpringSecEx.model;

import java.util.Collection;
import java.util.Collections;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class UserPrincipal implements UserDetails {

	private Users user;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Collections.singleton( new SimpleGrantedAuthority("USERS"));
	}

	@Override
	public @Nullable String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

}
