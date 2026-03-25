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
@RequestMapping("/student")
public class StudentController {

	@Autowired
	LessonRepository lessonRepo;

	@Autowired
	QuizRepository quizRepo;

	@Autowired
	ResultRepository resultRepo;

	// DASHBOARD
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session) {
		if (session.getAttribute("student") == null)
			return "redirect:/";
		return "student-dashboard";
	}

	// LESSONS
	@GetMapping("/lessons")
	public String lessons(Model model, HttpSession session) {

		if (session.getAttribute("student") == null)
			return "redirect:/";

		model.addAttribute("lessons", lessonRepo.findAll());
		return "lessons";
	}

	// OPEN QUIZ
	@GetMapping("/quiz/{id}")
	public String openQuiz(@PathVariable Long id, Model model, HttpSession session) {

		if (session.getAttribute("student") == null)
			return "redirect:/";

		Optional<Quiz> quiz = quizRepo.findById(id);
		if (quiz.isEmpty())
			return "redirect:/student/lessons";

		model.addAttribute("quiz", quiz.get());
		return "quiz";
	}

	// SUBMIT QUIZ
	@PostMapping("/submit-quiz")
	public String submitQuiz(@RequestParam Long quizId, @RequestParam String answer, Model model, HttpSession session) {

		Student student = (Student) session.getAttribute("student");
		if (student == null)
			return "redirect:/";

		Quiz quiz = quizRepo.findById(quizId).orElse(null);
		if (quiz == null)
			return "redirect:/student/lessons";

		int score = answer.equalsIgnoreCase(quiz.getCorrectAnswer()) ? 1 : 0;

		Result result = new Result();
		result.setQuiz(quiz);
		result.setStudent(student);
		result.setSelectedAnswer(answer);
		result.setScore(score);

		resultRepo.save(result);

		model.addAttribute("score", score);
		return "result";
	}

	// VIEW RESULTS
	@GetMapping("/results")
	public String results(Model model, HttpSession session) {

		Student student = (Student) session.getAttribute("student");
		if (student == null)
			return "redirect:/";

		model.addAttribute("results", resultRepo.findByStudent(student));
		return "student-results";
	}
}