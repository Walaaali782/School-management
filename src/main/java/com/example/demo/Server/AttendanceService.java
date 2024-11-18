package com.example.demo.Server;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Attendance;
import com.example.demo.Entity.AttendanceDto;
import com.example.demo.Entity.Student;
import com.example.demo.Repository.AttendanceRepository;
import com.example.demo.Repository.StudentRepository;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Attendance markAttendance(AttendanceDto attendanceDto) {
        Student student = studentRepository.findById(attendanceDto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Attendance attendance = new Attendance();
        attendance.setStudent(student);
        attendance.setDate(attendanceDto.getDate());
        attendance.setStatus(attendanceDto.getStatus());

        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAttendanceByStudent(Long studentId) {
        return attendanceRepository.findByStudentId(studentId);
    }

  
    
    public List<Attendance> getAttendanceForStudent(Long studentId) {
        return attendanceRepository.findAttendanceByStudentId(studentId);
    }
    
    public List<Attendance> getAttendanceForGroup(String group, LocalDate date) {
        return attendanceRepository.findAttendanceForGroupAndDate(group, date);
    }

}
