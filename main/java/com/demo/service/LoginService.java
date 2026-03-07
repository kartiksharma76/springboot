package com.demo.service;

import org.springframework.stereotype.Service;
//loginService,logoutService
@Service("kartikService")
public class LoginService implements MyService {
	public void test() {
		System.out.println("login service");
	}
}
