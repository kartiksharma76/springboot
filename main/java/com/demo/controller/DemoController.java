package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {
	@GetMapping("/")
	public String test() {
		return "Server is up";
	}

	@GetMapping("/getStudent")
	public Student getStudentById(@RequestParam(name = "id") int id) {
		Student student = new Student();
		if (id == 10) {
			student.setId(10);
			student.setName("Kartik");
			//student.setCollege("SIRT");
		}
		return student;
	}

	@PostMapping("/saveStudent")
	public String saveStudent(@RequestBody Student student) {
	//	System.out.println(student.getId() + " " + student.getName() + " " + student.getCollege());
		return "Data saved successfully";
	}

	@GetMapping("/greeting/firstName/{firstName}/lastName/{lastName}")
	public String greeting(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
		System.out.println(firstName + " " + lastName);
		return "Welcome" + " " + firstName + " " + lastName;
	}

}


