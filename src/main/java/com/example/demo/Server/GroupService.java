package com.example.demo.Server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Group;
import com.example.demo.Entity.Student;
import com.example.demo.Repository.GroupRepository;
import com.example.demo.Repository.StudentRepository;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public Student addStudentToGroup(Long groupId, Student student) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));
        student.setGroup(group);
        return studentRepository.save(student);
    }

    public List<Student> getStudentsInGroup(Long groupId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));
        return group.getStudents();
    }
}
