package com.example.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.ClassRoom;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {
}