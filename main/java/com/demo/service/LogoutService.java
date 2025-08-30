package com.demo.service;

import org.springframework.stereotype.Service;

@Service
public class LogoutService implements MyService{
	public void test() {
		System.out.println("logout service");
	}

}
