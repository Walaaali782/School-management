package com.example.demo.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Student;
import com.example.demo.Server.AttendanceService;
import com.example.demo.Server.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
 
    private AttendanceService attendanceService;
    
    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id) {
        return studentService.getStudentById(id); 
    }


    @GetMapping("/classroom/{classRoomId}")
    public ResponseEntity<List<Student>> getStudentsByClassRoom(@PathVariable Long classRoomId) {
        List<Student> students = studentService.getStudentsByClassRoom(classRoomId);

        if (students == null || students.isEmpty()) {
            return ResponseEntity.notFound().build();  
        }

        return ResponseEntity.ok(students);
    }

    @GetMapping("/{studentId}/attendance")
    public ResponseEntity<?> getStudentAttendance(@PathVariable Long studentId) {
        if (attendanceService == null) {
            // Log an error or handle the case where attendanceService is not injected
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Attendance service is not available.");
        }
        // Proceed with your logic
        return ResponseEntity.ok(attendanceService.getAttendanceForStudent(studentId));
    }
}