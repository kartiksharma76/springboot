package com.demo.ioc;

import org.springframework.stereotype.Component;

@Component
public class Engine {
	public void start() {
		System.out.println("EngineStarted");

	}

}
