package com.example.digitallearning.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String videoUrl;

    @ManyToOne
    private Teacher teacher;
}