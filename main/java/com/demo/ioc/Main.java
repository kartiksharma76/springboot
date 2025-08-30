package com.demo.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Main {
	@Autowired
private Engine engine;
	@Autowired
private Car car;
	
	public void run() {
		System.out.println("car run");
		engine.start();
		car.drive();
	}
}
