package com.example.demo.Controller;


import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.ClassRoom;
import com.example.demo.Server.ClassRoomService;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassRoomController {

    private final ClassRoomService classRoomService;

    public ClassRoomController(ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }

    @GetMapping
    public List<ClassRoom> getAllClassRooms() {
        return classRoomService.getAllClassRooms();
    }

    @PostMapping
    public ClassRoom addClassRoom(@RequestBody ClassRoom classRoom) {
        return classRoomService.addClassRoom(classRoom);
    }
}
