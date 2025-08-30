package com.demo.ioc;

import org.springframework.stereotype.Component;

@Component
public class B {
	public void m2() {
		System.out.println("m2() from B");
	}
}
