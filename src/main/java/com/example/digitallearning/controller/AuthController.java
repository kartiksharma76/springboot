package com.example.digitallearning.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.digitallearning.entity.*;
import com.example.digitallearning.repository.*;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	TeacherRepository teacherRepo;

	@GetMapping("/")
	public String loginPage() {
		return "login";
	}

	// STUDENT LOGIN
	@PostMapping("/student-login")
	public String studentLogin(@RequestParam String email, @RequestParam String password, Model model,
			HttpSession session) {

		Optional<Student> student = studentRepo.findByEmail(email);

		if (student.isPresent() && student.get().getPassword().equals(password)) {
			session.setAttribute("student", student.get());
			return "redirect:/student/dashboard";
		}

		model.addAttribute("error", "Invalid Student Login");
		return "login";
	}

	// TEACHER LOGIN
	@PostMapping("/teacher-login")
	public String teacherLogin(@RequestParam String email, @RequestParam String password, Model model,
			HttpSession session) {

		Optional<Teacher> teacher = teacherRepo.findByEmail(email);

		if (teacher.isPresent() && teacher.get().getPassword().equals(password)) {
			session.setAttribute("teacher", teacher.get());
			return "redirect:/teacher/dashboard";
		}

		model.addAttribute("error", "Invalid Teacher Login");
		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}