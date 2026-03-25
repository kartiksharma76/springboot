package com.demo.service;

public interface MyService {
default void test() {
	System.out.println("test service");
}

}
