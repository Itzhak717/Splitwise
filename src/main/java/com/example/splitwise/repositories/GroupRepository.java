package com.example.splitwise.repositories;

import com.example.splitwise.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findGroupsByUsers_Id(Long userId);
}
