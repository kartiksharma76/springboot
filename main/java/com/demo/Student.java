package com.demo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
public class Student {
private String name;
private String college;
private int rollNumber;
private String address;


}
