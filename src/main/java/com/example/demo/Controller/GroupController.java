package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Group;
import com.example.demo.Entity.Student;
import com.example.demo.Server.AttendanceService;
import com.example.demo.Server.GroupService;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        return ResponseEntity.ok(groupService.createGroup(group));
    }

    @PostMapping("/{groupId}/students")
    public ResponseEntity<Student> addStudentToGroup(@PathVariable Long groupId, @RequestBody Student student) {
        return ResponseEntity.ok(groupService.addStudentToGroup(groupId, student));
    }

    @GetMapping("/{groupId}/students")
    public ResponseEntity<List<Student>> getStudentsInGroup(@PathVariable Long groupId) {
        return ResponseEntity.ok(groupService.getStudentsInGroup(groupId));
    }
    
    @Autowired
    private AttendanceService attendanceService; 

   

}
