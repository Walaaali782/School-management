package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
