package com.demo.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class C {
	@Autowired
	private B b;
	@Autowired
	private A a;

	public void m3() {
		System.out.println("m3() from C");
		b.m2();
		a.m1();
	}
}
