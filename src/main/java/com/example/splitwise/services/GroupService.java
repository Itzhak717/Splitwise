package com.example.splitwise.services;

import com.example.splitwise.models.Group;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    Group getGroupById(Long id);

    List<Group> getGroupsByUserId(Long userId);

    void createGroup(Group group);

    void updateGroup(Group group);

    void addUserToGroup(Long id, Long userId);

    void deleteGroup(Long id);

    void removeUserFromGroup(Long id, Long userId);
}
