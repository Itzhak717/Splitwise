package com.example.splitwise.services.Impl;

import com.example.splitwise.models.Group;
import com.example.splitwise.models.User;
import com.example.splitwise.repositories.GroupRepository;
import com.example.splitwise.services.GroupService;
import com.example.splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserService userService;

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.findById(id).orElseThrow(() -> new RuntimeException("Group not found"));
    }

    @Override
    public List<Group> getGroupsByUserId(Long userId) {
        return groupRepository.findGroupsByUsers_Id(userId);
    }

    @Override
    public void createGroup(Group group) {
        groupRepository.save(group);
    }

    @Override
    public void updateGroup(Group group) {
        Group existingGroup = groupRepository.findById(group.getId()).orElseThrow(() -> new RuntimeException("Group not found"));
        existingGroup.setTitle(group.getTitle());
        existingGroup.setPhoto(group.getPhoto());
        existingGroup.setBulletin(group.getBulletin());
        existingGroup.setUsers(group.getUsers());

        groupRepository.save(existingGroup);
    }

    @Override
    public void addUserToGroup(Long id, Long userId) {
        Group existingGroup = groupRepository.findById(id).orElseThrow(() -> new RuntimeException("Group not found"));
        User user = userService.getUserById(userId);
        Set<User> groupUsers = existingGroup.getUsers();
        groupUsers.add(user);
        existingGroup.setUsers(groupUsers);

        groupRepository.save(existingGroup);
    }

    @Override
    public void deleteGroup(Long id) {
        //TODO: delete all the expenses and transactions related to this group
    }

    @Override
    public void removeUserFromGroup(Long id, Long userId) {
        Group existingGroup = groupRepository.findById(id).orElseThrow(() -> new RuntimeException("Group not found"));
        User user = userService.getUserById(userId);
        Set<User> groupUsers = existingGroup.getUsers();
        groupUsers.remove(user);
        existingGroup.setUsers(groupUsers);

        groupRepository.save(existingGroup);
    }
}
