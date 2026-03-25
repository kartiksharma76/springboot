package com.demo.ioc;

import org.springframework.stereotype.Component;

@Component
public class Car {
public void drive() {
	System.out.println("car is moving");
}
}
