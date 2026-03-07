package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.repository.StudentRepository;

@RestController
public class HostelController {
	@Autowired
	private StudentRepository repository;

	@PostMapping("hostel/student/save")
	public String saveData(@RequestBody Student student) {
		System.out.println(student);
		repository.save(student);
		return "data saved successfully";
	}

	@GetMapping("/hostel/student/get/id/{id}")
	public ResponseEntity<Object> test(@PathVariable(name = "id") int id) {
		Optional<Student> student = repository.findById(id);
		if (student.isPresent()) {
			return new ResponseEntity<>(student, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("student record not found", HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/hostel/student/get/mobileNumber/{mobileNumber}")
	public ResponseEntity<Object> getStudentByMobileNumber(@PathVariable(name = "mobileNumber") String mobileNumber) {
		Optional<Student> student = repository.findBymobileNumber(mobileNumber);
		if (student.isPresent()) {
			return new ResponseEntity<>(student, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("student record not found", HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/hostel/student/get/roomId/{roomId}")
	public ResponseEntity<Object> getStudentByroomId(@PathVariable(name = "roomId") String roomId) {
		Optional<Student> student = repository.findByroomId(roomId);
		if (student.isPresent()) {
			return new ResponseEntity<>(student, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("student record not found", HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("hostel/student/delete")
	public String deleteById(@RequestParam(name = "id") int id) {
		repository.deleteById(id);
		return id + " deleted successfully";
	}

	@GetMapping("hostel/student/delete/id/{id}")
	public String deleteBy(@PathVariable(name = "id") int id) {
		repository.deleteById(id);
		return id + "deleted succesfully";
	}

//  UPDATE THROUGH URL
	@PostMapping("/hostel/student/updateName")
	public String updateStudentName(@RequestParam int id, @RequestParam String name) {
		return repository.findById(id).map(student -> {
			student.setName(name);
			repository.save(student);
			return "Name updated successfully for student with id " + id;
		}).orElse("Student not found with id " + id);
	}

//  UPDATE THROUGH URL
	@PostMapping("/hostel/student/updateName/{id}/{name}")
	public String updateStudent(@PathVariable int id, @PathVariable String name) {
		return repository.findById(id).map(student -> {
			student.setName(name);
			repository.save(student);
			return "Name updated successfully for student with id " + id;
		}).orElse("Student not found with id " + id);
	}

//  UPDATE THROUGH URL
	@PostMapping("/hostel/student/updateEmail/{id}/{email}")
	public String updateStudentEmail(@PathVariable int id, @PathVariable String email) {
		return repository.findById(id).map(student -> {
			student.setEmail(email);
			repository.save(student);
			return "Email updated successfully for student with id " + id;
		}).orElse("Student not found with id " + id);
	}
	// Get Student by Email
	@GetMapping("/hostel/student/get/email/{email}")
	public ResponseEntity<Object> getStudentByEmail(@PathVariable String email) {
	    Optional<Student> student = repository.findByEmailStudent(email);
	    if (student.isPresent()) {
	        return new ResponseEntity<>(student.get(), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("No student found with email " + email, HttpStatus.NOT_FOUND);
	    }
	}


	

	}





