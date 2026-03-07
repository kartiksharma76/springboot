package com.example.digitallearning.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.digitallearning.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Long>{
    Optional<Teacher> findByEmail(String email);
}