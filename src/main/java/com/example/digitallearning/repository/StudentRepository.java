package com.example.digitallearning.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.digitallearning.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
    Optional<Student> findByEmail(String email);
}