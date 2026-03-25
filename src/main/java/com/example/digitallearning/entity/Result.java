package com.example.digitallearning.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String selectedAnswer;
    private int score;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Quiz quiz;
}