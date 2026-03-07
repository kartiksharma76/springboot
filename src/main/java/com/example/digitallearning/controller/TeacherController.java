package com.example.digitallearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.digitallearning.entity.*;
import com.example.digitallearning.repository.*;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	LessonRepository lessonRepo;

	@Autowired
	QuizRepository quizRepo;

	// DASHBOARD
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {

		if (session.getAttribute("teacher") == null)
			return "redirect:/";

		model.addAttribute("lessons", lessonRepo.findAll());
		return "teacher-dashboard";
	}

	// ADD LESSON
	@PostMapping("/add-lesson")
	public String addLesson(@ModelAttribute Lesson lesson, HttpSession session) {

		Teacher teacher = (Teacher) session.getAttribute("teacher");
		lesson.setTeacher(teacher);
		lessonRepo.save(lesson);

		return "redirect:/teacher/dashboard";
	}

	// ADD QUIZ
	@PostMapping("/add-quiz")
	public String addQuiz(@RequestParam Long lessonId, @ModelAttribute Quiz quiz, HttpSession session) {

		if (session.getAttribute("teacher") == null)
			return "redirect:/";

		Lesson lesson = lessonRepo.findById(lessonId).orElse(null);
		if (lesson == null)
			return "redirect:/teacher/dashboard";

		quiz.setLesson(lesson);
		quizRepo.save(quiz);

		return "redirect:/teacher/dashboard";
	}
}