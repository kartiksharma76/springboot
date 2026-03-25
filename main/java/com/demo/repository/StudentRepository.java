package com.demo.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.controller.Student;


public interface StudentRepository extends JpaRepository<Student, Integer>{
public Optional<Student> findBymobileNumber(String mobileNumber);
public Optional<Student> findByroomId(String roomId);
//Declare query at the query method using @Query
@Query("select s from Student s where s.email = :email")
Optional<Student> findByEmail(@Param("email") String email);


// use like queries
@Query("select s from Student s where s.name like %:name")
Optional<Student> findByNameEndsWith(@Param("name") String name);


@Query(value = "SELECT * FROM student WHERE email = ?1", nativeQuery = true)
Optional<Student> findByEmailStudent(String email);


//public Optional<Student>findByEmail(String email);
//@Query("select s from Student s where s.email = ?1")
//Student findByEmail(String email);
//public List<Student> findByLastName(String lastname);

//}
//@Query("select s from student s where s.fatherMobileNumber=:fatherMobileNumber")
//public Optional<Student> findByfatherMobileNumber(@Param("fatherMobileNumber") String fatherMobileNumber);


}