package com.example.splitwise.controllers;

import com.example.splitwise.models.Group;
import com.example.splitwise.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/api/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/{id}")
    public Group getGroupById(@PathVariable Long id) {
        return groupService.getGroupById(id);
    }

    @GetMapping
    public List<Group> getGroupsByUserId(@PathVariable Long userId) {
        return groupService.getGroupsByUserId(userId);
    }

    @PostMapping
    public void createGroup(@RequestBody Group group) {
        groupService.createGroup(group);
    }

    @PostMapping("/{id}")
    public void updateGroup(@RequestBody Group group) {
        groupService.updateGroup(group);
    }

    @PostMapping("/{id}/users")
    public void addUserToGroup(@PathVariable Long id, @RequestBody Long userId) {
        groupService.addUserToGroup(id, userId);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id);
    }

    @DeleteMapping("/{id}/users/{userId}")
    public void removeUserFromGroup(@PathVariable Long id, @PathVariable Long userId) {
        groupService.removeUserFromGroup(id, userId);
    }
}
