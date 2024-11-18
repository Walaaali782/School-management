package com.example.demo.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByStudentId(Long studentId);



    @Query("SELECT a FROM Attendance a WHERE a.group = :group AND a.date = :date")
    List<Attendance> findAttendanceForGroupAndDate(@Param("group") String group, @Param("date") LocalDate date);

    List<Attendance> findAttendanceByStudentId(Long studentId);
    
}
