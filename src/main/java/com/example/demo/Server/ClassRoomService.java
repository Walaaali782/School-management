package com.example.demo.Server;


import org.springframework.stereotype.Service;

import com.example.demo.Entity.ClassRoom;
import com.example.demo.Repository.ClassRoomRepository;

import java.util.List;

@Service
public class ClassRoomService {

    private final ClassRoomRepository classRoomRepository;

    public ClassRoomService(ClassRoomRepository classRoomRepository) {
        this.classRoomRepository = classRoomRepository;
    }

    public List<ClassRoom> getAllClassRooms() {
        return classRoomRepository.findAll();
    }

    public ClassRoom addClassRoom(ClassRoom classRoom) {
        return classRoomRepository.save(classRoom);
    }
}
