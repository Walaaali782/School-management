package com.example.demo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Query("SELECT s FROM Student s JOIN s.classRoom c WHERE c.id = :classRoomId")
    List<Student> findByClassRoomId(@Param("classRoomId") Long classRoomId);
	
	
}
