package com.demo.bean;

import lombok.Getter;
import lombok.Setter;

@Getter

public class Dog {
	private String name = "moti";
	private int age = 16;
//
//	public Dog() {
//
//	}

	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

}
