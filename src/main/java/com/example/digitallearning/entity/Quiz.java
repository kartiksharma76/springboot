package com.example.digitallearning.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctAnswer;

    @ManyToOne
    private Lesson lesson;
}