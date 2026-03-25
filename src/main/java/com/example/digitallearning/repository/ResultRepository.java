package com.example.digitallearning.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.digitallearning.entity.*;

public interface ResultRepository extends JpaRepository<Result,Long>{

    List<Result> findByStudent(Student student);
}