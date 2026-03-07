package com.example.digitallearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.digitallearning.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson,Long>{}