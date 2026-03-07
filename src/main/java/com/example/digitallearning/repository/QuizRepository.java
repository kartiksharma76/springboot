package com.example.digitallearning.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.digitallearning.entity.*;

public interface QuizRepository extends JpaRepository<Quiz,Long>{

    List<Quiz> findByLesson(Lesson lesson);
}